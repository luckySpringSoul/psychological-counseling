package com.rys.response.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserBaseInfo {

    @ApiModelProperty(value = "用户姓名")
    private String userName;

    @ApiModelProperty(value = "用户联系电话")
    private String userTel;

    @ApiModelProperty(value = "手动填写的详细地址")
    private String detailedAddress;

}
