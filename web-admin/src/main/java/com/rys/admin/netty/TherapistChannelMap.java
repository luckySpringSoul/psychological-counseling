package com.rys.admin.netty;

import io.netty.channel.Channel;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * 建立用户ID与通道的关联
 */
@Slf4j
public class TherapistChannelMap {

    // 用户保存用户id与通道的Map对象
    private static Map<String, Channel> userChannelMap;

    static {
        userChannelMap = new HashMap<>();
    }

    /**
     * 添加咨询师id与channel的关联
     *
     * @param therapistId
     * @param channel
     */
    public static void put(String therapistId, Channel channel) {
        userChannelMap.put(therapistId, channel);
    }

    /**
     * 根据咨询师id移除用户id与channel的关联
     *
     * @param therapistId
     */
    public static void remove(String therapistId) {
        userChannelMap.remove(therapistId);
    }

    /**
     * 根据通道id移除用户与channel的关联
     *
     * @param channelId 通道的id
     */
    public static void removeByChannelId(String channelId) {
        if (!StringUtils.isNotBlank(channelId)) {
            return;
        }

        for (String therapistId : userChannelMap.keySet()) {
            Channel channel = userChannelMap.get(therapistId);
            if (channelId.equals(channel.id().asLongText())) {
                log.info("咨询师端连接断开,取消咨询师" + therapistId + "与通道" + channelId + "的关联");
                userChannelMap.remove(therapistId);
                break;
            }
        }
    }

    // 打印所有的用户与通道的关联数据
    public static void print() {
        for (String s : userChannelMap.keySet()) {
            log.info("咨询师id:" + s + " 通道:" + userChannelMap.get(s).id());
        }
    }

    /**
     * 根据用户id获取对应的通道
     */
    public static Channel get(String friendid) {
        return userChannelMap.get(friendid);
    }
}
