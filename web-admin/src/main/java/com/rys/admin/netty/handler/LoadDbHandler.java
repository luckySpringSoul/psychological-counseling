package com.rys.admin.netty.handler;


import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.rys.admin.netty.Message;
import com.rys.admin.netty.TherapistChannelMap;
import com.rys.entity.Result;
import com.rys.service.doctor.Bo.ReceiveMessageBo;
import com.rys.utils.SpringUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 处理消息的handler
 */
@Slf4j
public class LoadDbHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    // 用来保存所有的用户连接
    private static ChannelGroup clients = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    public static final String REGISTER = "CONNECT";

    public static final String SEND_MSG = "SEND_MSG";


    // 当Channel中有新的事件消息会自动调用
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {

        ThreadPoolTaskExecutor poolTaskExecutor = SpringUtil.getBean(ThreadPoolTaskExecutor.class);

        poolTaskExecutor.setThreadNamePrefix("online-send-user-msg-");

        // 当接收到数据后会自动调用
        // 获取客户端发送过来的文本消息
        String text = msg.text();
        Message message = JSON.parseObject(text, Message.class);
        log.info("socket channel message->>>>>>>>>{}", JSON.toJSONString(message));

        switch (message.getMessageType()) {
            case REGISTER:
                // 建立用户与通道的关联
                log.info("建立咨询师与通道的关联");
                String userid = message.getFromUserId();
                TherapistChannelMap.put(message.getFromRoleType() + "_" + userid, ctx.channel());
                log.info("建立咨询师:" + userid + "与通道" + ctx.channel().id() + "的关联");
                TherapistChannelMap.print();
                break;
            // 处理客户端发送的心跳消息
            case SEND_MSG:
                ReceiveMessageBo receiveMessageBo = ReceiveMessageBo.builder()
                    .formUserId(message.getFromUserId())
                    .msg(message.getMsg())
                    .toUserId(message.getToUserId())
                    .build();
                Channel channel = TherapistChannelMap.get(
                    message.getToRoleType() + "_" + receiveMessageBo.getToUserId());
                if (channel != null) {
                    log.info("发送消息为 {}", receiveMessageBo.getMsg());
                    channel.writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(receiveMessageBo)));
                    log.info("发送成功");
                }
                break;
        }
    }

    // 当有新的用户端连接服务器之后，会自动调用这个方法
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        // 将新的通道加入到clients
        clients.add(ctx.channel());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        TherapistChannelMap.removeByChannelId(ctx.channel().id().asLongText());
        ctx.channel().close();
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        log.info("关闭通道");
        TherapistChannelMap.removeByChannelId(ctx.channel().id().asLongText());
        TherapistChannelMap.print();
    }
}