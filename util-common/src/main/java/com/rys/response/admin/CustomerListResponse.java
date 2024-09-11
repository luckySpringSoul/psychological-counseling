package com.rys.response.admin;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class CustomerListResponse implements Serializable {

    @ApiModelProperty(value = "主键code")
    private Integer code;

    @ApiModelProperty(value = "员工编号")
    private String staffNo;

    @ApiModelProperty(value = "员工姓名")
    private String staffName;

    @ApiModelProperty(value = "客户姓名")
    private String customerName;

    @ApiModelProperty(value = "客户手机号")
    private String customerPhone;

    @ApiModelProperty(value = "客户类型 1个体 2企业 3学校 4物业 5社区")
    private Integer customerType;

    @ApiModelProperty(value = "审核状态 1待审核 2审核成功 3审核失败 ")
    private Integer status;

    @ApiModelProperty(value = "是否结算 0否1是 ")
    private Integer settlement;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "结算时间")
    private String settlementTime;


    @ApiModelProperty(value = "审核时间")
    private String auditTime;

    @ApiModelProperty(value = "收益金额")
    private BigDecimal profit;

}
