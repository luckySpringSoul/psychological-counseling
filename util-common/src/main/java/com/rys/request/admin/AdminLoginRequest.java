package com.rys.request.admin;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AdminLoginRequest {

    /**
     * 登录账号
     * */
    @ApiModelProperty(name = "account",example = "邹account",required = true,value = "登录账户")
    private String account;

    /**
     * 登录方式
     * */
    @ApiModelProperty(name = "loginType",example = "0",required = false,value = "登录类型,目前只有密码登录")
    private Integer loginType;

    /**
     * 登录密码
     * */
    @ApiModelProperty(name = "password",example = "123456",required = true,value = "密码,密码需要加密")
    private String password;
}
