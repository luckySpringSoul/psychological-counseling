package com.rys.response.user.login;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName WxLoginVo
 * @Description TODO
 * @Author Administrator
 * @Date 2020/8/27
 * @Version 1.0.0
 */
@Data
@ApiModel(value="登陆返回对象", description="登陆返回对象")
public class LoginResponse {
    /**
     * 如果有手机号则有此项有值
     */
    @ApiModelProperty(value = "如果有手机号则有此项有值")
    private String token;
    /**
     * 手机号码
     */

    @ApiModelProperty(value = "手机号码")

    private String mobilePhone;

    /**
     * 是否是首次登录
     */
    @ApiModelProperty(value = "是否是首次登录")

    private boolean haveRegistered;
}
