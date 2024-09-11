package com.rys.response.user.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value="用户信息对象", description="用户信息对象")
public class UserInfoResponse implements Serializable {

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

    @ApiModelProperty(value = "微信头像")
    private String headUrl;

    @ApiModelProperty(value = "微信openid")
    private String openid;

    @ApiModelProperty(value = "1 正常 2 禁用")
    private Integer status;

}
