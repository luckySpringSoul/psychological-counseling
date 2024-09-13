package com.rys.request.user.login.wechat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName LoginByWx
 * @Description TODO
 * @Author Administrator
 * @Date 2020/8/27
 * @Version 1.0.0
 */
@Data
@ApiModel(value="微信登陆对象", description="微信登陆")
public class LoginByWcAppletRequest{
    /**
     * 登录凭证
     */
    @ApiModelProperty(value = "登录凭证")
    private String code;
    /**
     * 手机号加密数据
     */
    @ApiModelProperty(value = "手机号加密数据")
    private String data;
    /**
     * 数据签名
     */
    @ApiModelProperty(value = "数据签名")

    private String signature;
    /**
     * 加密向量
     */
    @ApiModelProperty(value = "加密向量")
    private String vi;

    @ApiModelProperty(value = "微信昵称")

    private String nickName;

    @ApiModelProperty(value = "头像地址")

    private String headUrl;


    @ApiModelProperty(value = "性别 1男 2女")
    private Integer gender;
}
