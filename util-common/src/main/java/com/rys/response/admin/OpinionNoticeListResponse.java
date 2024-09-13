package com.rys.response.admin;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class OpinionNoticeListResponse implements Serializable {

    @ApiModelProperty(value = "主键code")
    private Integer code;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "意见")
    private String opinion;

    @ApiModelProperty(value = "处理状态 1未处理 2已处理")
    private String status;

    @ApiModelProperty(value = "用户名称")
    private String name;
    @ApiModelProperty(value = "用户电话")
    private String phone;

}
