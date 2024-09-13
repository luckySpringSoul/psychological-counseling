package com.rys.entity.user.wechat;

import lombok.Data;
import lombok.ToString;

/**
 * @ClassName WebChatAccessTokenResDto
 * @Description TODO
 * @Author Administrator
 * @Date 2020/8/26
 * @Version 1.0.0
 */
@Data
@ToString
public class WChatAppResDto extends ErrorInfo {
    private String access_token;
    private int expires_in;
    private String refresh_token;
    private String openid;
    private String scope;
    private String unionid;
}
