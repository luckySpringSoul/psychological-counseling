package com.rys.request.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value="用户信息对象", description="用户信息对象")
public class UserInfoRequest implements Serializable {

    @ApiModelProperty(value = "用户ID")
    private Long userId;

    @ApiModelProperty(value = "用户姓名")
    private String userName;

    @ApiModelProperty(value = "用户手机号")
    private String userTel;

    @ApiModelProperty(value = "1 男 2 女")
    private Integer gender;

    @ApiModelProperty(value = "头像")
    private String headUrl;

    @ApiModelProperty(value = "身份证号码")
    private String idCard;

    @ApiModelProperty(value = "地址")
    private String address;

}
