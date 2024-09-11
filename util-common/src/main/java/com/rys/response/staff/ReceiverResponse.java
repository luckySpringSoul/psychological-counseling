package com.rys.response.staff;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ReceiverResponse {


    @ApiModelProperty(value = "员工id")
    private Long code;

    @ApiModelProperty(value = "员工姓名")
    private String name;

    @ApiModelProperty(value = "员工电话")
    private String tel;

    @ApiModelProperty(value = "员工状态,1:回收中,2:接单中")
    private Integer status;

    @ApiModelProperty(value = "归属,目前只有平台")
    private String source;

    @ApiModelProperty(value = "距离用户")
    private Double distance;


}
