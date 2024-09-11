package com.rys.response.admin;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AdminLoginResponse {

    @ApiModelProperty(value = "token")
    private String token;

    @ApiModelProperty(value = "adminCode")
    private Integer adminCode;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "登录账户")
    private String account;

    @ApiModelProperty(value = "部门id")
    private String deptId;

}
