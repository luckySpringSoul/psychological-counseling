package com.rys.request.staff;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UpdatePwdRequst {
    @ApiModelProperty(name = "oldPwd",example = "123456",required = true,value = "旧密码")
    private String oldPwd;


    @ApiModelProperty(name = "newPwd",example = "12345678",required = true,value = "新密码")
    private String newPwd;

    @ApiModelProperty(name = "repeatNewPwd",example = "12345678",required = true,value = "确认新密码")
    private String repeatNewPwd;

    private String id;

}
