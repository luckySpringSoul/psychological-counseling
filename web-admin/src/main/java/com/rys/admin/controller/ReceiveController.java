package com.rys.admin.controller;

import com.rys.admin.netty.TherapistChannelMap;
import com.rys.annotation.Anonymous;
import com.rys.entity.Result;
import com.rys.service.doctor.Bo.ReceiveMessageBo;
import io.netty.channel.Channel;
import io.swagger.annotations.ApiOperation;
import java.util.Objects;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wh-yiloutingfengyu
 * @version 1.0.0
 * @ClassName ReceiveController.java
 * @Description
 * @createTime 2024年09月09日 21:51:00
 */
@RestController
@Anonymous
public class ReceiveController {

    @PostMapping("/send/msg")
    @ApiOperation("给用户发送消息")
    public Result receiveMsg(@RequestBody ReceiveMessageBo receiveMessageBo) {
        Channel channel = TherapistChannelMap.get(1 + "_" + receiveMessageBo.getToUserId());
        if (Objects.isNull(channel)) {
            return Result.fail("用户已经下线");
        }
        channel.writeAndFlush(receiveMessageBo.getMsg());
        return Result.success();
    }

    @PostMapping("/send/therapist/msg")
    @ApiOperation("给咨询师发送消息")
    public Result receiveTherapistMsg(@RequestBody ReceiveMessageBo receiveMessageBo) {
        Channel channel = TherapistChannelMap.get(2 + "_" + receiveMessageBo.getToUserId());
        if (Objects.isNull(channel)) {
            return Result.fail("咨询师已经下线");
        }
        channel.writeAndFlush(receiveMessageBo.getMsg());
        return Result.success();
    }

}
