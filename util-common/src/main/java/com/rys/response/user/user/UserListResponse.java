package com.rys.response.user.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserListResponse implements Serializable {

    @ApiModelProperty(value = "用户ID")
    private Long code;

    @ApiModelProperty(value = "用户姓名")
    private String userName;

    @ApiModelProperty(value = "用户手机号")
    private String userTel;

    @ApiModelProperty(value = "1 男 2 女")
    private Integer gender;

    @ApiModelProperty(value = "当前等级 默认1")
    private Integer Level;

    @ApiModelProperty(value = "微信昵称")
    private String nickName;


    @ApiModelProperty(value = "下单次数")
    private Long orderNo;

    @ApiModelProperty(value = "积分")
    private Integer integral;


    @ApiModelProperty(value = "加入时间")
    private String createTime;
}
