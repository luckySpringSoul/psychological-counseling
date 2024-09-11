package com.rys.response.staff;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LoginResponse {

    @ApiModelProperty(value = "token")
    private String token;

    @ApiModelProperty(value = "用户code")
    private Long userCode;

    @ApiModelProperty(value = "姓名")
    private String userName;

    @ApiModelProperty(value = "角色  1 回收员  2地推员工  3销售员工")
    private Integer type;

}
