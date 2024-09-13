package com.rys.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName AuthorizeConfig
 * @Description TODO
 * @Author Administrator
 * @Date 2020/8/26
 * @Version 1.0.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "config.authorize.webchatapp")
public class WebChatAppConfig {
    private String appId;
    private String secret;
    private String appAccessTokenUrl;
    private String appUserInfoUrl;
}
