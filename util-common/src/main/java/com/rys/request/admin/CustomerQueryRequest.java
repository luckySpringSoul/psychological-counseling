package com.rys.request.admin;

import com.rys.request.RequestPage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CustomerQueryRequest extends RequestPage {

    @ApiModelProperty(value = "员工编号")
    private String staffNo;

    @ApiModelProperty(value = "员工姓名")
    private String staffName;

    @ApiModelProperty(value = "员工手机号")
    private String staffPhone;

    @ApiModelProperty(value = "合作客户手机号",example = "天府奶茶店")
    private String customerPhone;

    @ApiModelProperty(value = "合作客户名称",example = "天府奶茶店")
    private String customerName;

    @ApiModelProperty(value = "是否结算 0否 1是")
    private Integer settlement;

    @ApiModelProperty(name = "status",example = "1",required = false,value = "审核状态 1待审核 2审核成功 3审核失败")
    private Integer status;

    @ApiModelProperty(name = "createStartTime",example = "2021-07-20",required = false,value = "创建开始时间")
    private String createStartTime;

    @ApiModelProperty(name = "createEndTime",example = "2021-07-20",required = false,value = "创建结束时间")
    private String createEndTime;

    @ApiModelProperty(name = "auditStartTime",example = "2021-07-20",required = false,value = "审核开始时间")
    private String auditStartTime;

    @ApiModelProperty(name = "auditEndTime",example = "2021-07-20",required = false,value = "审核结束时间")
    private String auditEndTime;

    @ApiModelProperty(name = "settlementStartTime",example = "2021-07-20",required = false,value = "结算开始时间")
    private String settlementStartTime;

    @ApiModelProperty(name = "settlementEndTime",example = "2021-07-20",required = false,value = "结算结束时间")
    private String settlementEndTime;

}
