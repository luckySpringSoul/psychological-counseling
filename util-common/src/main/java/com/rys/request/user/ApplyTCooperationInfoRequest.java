package com.rys.request.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ApplyTCooperationInfoRequest implements Serializable {

    @ApiModelProperty(value = "状态 1企业 2政府 3机构 4个人")
    private Integer type;

    @ApiModelProperty(value = "1企业 2政府 3机构 4个人")
    private String typeName;

    @ApiModelProperty(value = "合作客户单位商户名称")
    private String customerName;

    @ApiModelProperty(value = "客户姓名")
    private String name;

    @ApiModelProperty(value = "客户电话")
    private String tel;

    @ApiModelProperty(value = "合作意向信息")
    private String cooperationInfo;

    @ApiModelProperty(value = "自动获取地址")
    private String address;

    @ApiModelProperty(value = "手动填写详细地址")
    private String detailedAddress;

    @ApiModelProperty(value = "省ID")
    private String province;

    @ApiModelProperty(value = "市ID")
    private String city;

    @ApiModelProperty(value = "区ID")
    private String district;
}
