package com.rys.entity.user.wechat;

import lombok.Data;

/**
 * @ClassName WebChatAccessTokenReqDto
 * @Description TODO
 * @Author Administrator
 * @Date 2020/8/26
 * @Version 1.0.0
 */
@Data
public class WChatAppReqDto {
    private String appid;
    private String secret;
    private String code;
    private String grant_type = "authorization_code";
}
