package com.rys.response.user.login;

import lombok.Data;

@Data
public class AppWCLoginResponse extends LoginResponse {
    /**
     * 回調码，用于第一次APP通过微信登录没有手机号码，需要手动添加手机号码时携带返回
     */
    private String callbackCode;
}
