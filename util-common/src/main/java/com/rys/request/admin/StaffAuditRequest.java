package com.rys.request.admin;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class StaffAuditRequest implements Serializable {

    @ApiModelProperty(value = "申请列表返回的code")
    private Long code;

    @ApiModelProperty(value = "审核状态 1同意  2拒绝")
    private Integer status;

    @ApiModelProperty(value = "审核备注")
    private String remark;
}
