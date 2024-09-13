package com.rys.admin.netty;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * @author tmo
 * @version 1.0.0
 * @ClassName Message.java
 * @Description 通道消息
 * @createTime 2024年09月07日 11:04:00
 */
@Data
public class Message implements Serializable {

    @ApiModelProperty(value = "消息类型,CONNECT:建立连接,SEND_MSG:发送消息")
    private String messageType;

    @ApiModelProperty(value = "当前用户id")
    private String fromUserId;

    @ApiModelProperty(value = "目标用户id")
    private String toUserId;

    @ApiModelProperty(value = "发送的消息")
    private String msg;

    @ApiModelProperty("角色类型 1用户 2咨询师")
    private Integer fromRoleType;

    @ApiModelProperty("角色类型 1用户 2咨询师")
    private Integer toRoleType;


}
