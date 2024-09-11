package com.rys.response.user.login;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author wh-yiloutingfengyu
 * @version 1.0.0
 * @ClassName LoginRequest.java
 * @Description
 * @createTime 2024年09月08日 17:40:00
 */
@Data
public class LoginRequest implements Serializable {

    @ApiModelProperty(value = "登陆手机号")
    @NotBlank(message = "请传入登陆手机号")
    private String phone;
    @ApiModelProperty(value = "登陆密码")
    @NotBlank(message = "请传入密码")
    private String password;
    @ApiModelProperty(value = "登陆类型 1用户 2咨询师")
    @NotNull(message = "请传入登陆类型！")
    private Integer roleType;

}
