package com.rys.response.customer;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CustomerDetailResponse {

    @ApiModelProperty(value = "合作客户单位商户名称",example = "天府奶茶店")
    private String customerName;

    @ApiModelProperty(value = "自动获取地址",example = "成都高新区")
    private String address;

    @ApiModelProperty(value = "手动填写详细地址",example = "天府五街")
    private String detailedAddress;

    @ApiModelProperty(value = "客户姓名",example = "张三")
    private String name;

    @ApiModelProperty(value = "客户电话",example = "18602870039")
    private String tel;

    @ApiModelProperty(value = "1个体 2企业 3学校 4物业 5社区",example = "1")
    private Integer customerType;

    @ApiModelProperty(value = "门头照")
    private String doorImgUrl;

    @ApiModelProperty(value = "二维码招聘")
    private String qrImgUrl;

    @ApiModelProperty(value = "视频地址")
    private String video;
}
