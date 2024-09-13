package com.rys.request.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value="OpinionNoticeRequest对象", description="用户意见对象")
public class OpinionNoticeRequest implements Serializable {

    @ApiModelProperty(value = "用户名称")
    private String name;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "图片1")
    private String url1;

    @ApiModelProperty(value = "图片2")
    private String url2;

    @ApiModelProperty(value = "意见类型。1下单意见 2骑手意见 3其他")
    private Integer opinionType;

    @ApiModelProperty(value = "图片3")
    private String url3;
}
