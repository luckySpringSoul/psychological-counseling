package com.rys.entity.user.wechat;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @ClassName WebChat
 * @Description TODO
 * @Author Administrator
 * @Date 2020/8/27
 * @Version 1.0.0
 */
@Data
public class UserWCInfo {
    /**
     * 用户对应本系统的ID
     */
    private long id = -1;
    /**
     * 第一次登录时返回的编码
     */
    private String callbackCode;

    /**
     * 访问token
     */
    private String token;
    /**
     * 过期时间
     */
    private LocalDateTime expiresIn;
    /**
     * 授权范围
     */
    private String scope;
    /**
     * openid
     */
    private String openid;
    /**
     * unionid
     */
    private String unionid;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 性别
     */
    private int sex;
    /**
     * 头像
     */
    private String headImageUrl;
    /**
     * 手机号码
     */
    private String mobilePhone;
    /**
     * 记录创建时间
     */
    private LocalDateTime createTime;
    /**
     * 记录创建修改
     */
    private LocalDateTime modifyTime;
    /**
     * 是否是首次登录
     */
    private boolean haveRegistered;
}
