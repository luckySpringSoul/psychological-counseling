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
public class WChatAppletResDto extends ErrorInfo {
    private String openid;
    private String session_key;
    private String unionid;
}
