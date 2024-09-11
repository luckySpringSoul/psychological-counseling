package com.rys.request.staff;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class ApplyStaffRequest implements Serializable {

    @ApiModelProperty(value = "员工姓名")
    @NotBlank(message = "姓名不能为空")
    private String name;

    @ApiModelProperty(value = "员工电话")
    @NotBlank(message = "联系电话不能为空")
    private String tel;


    @ApiModelProperty(value = "省份ID")
    @NotBlank(message = "省份不能为空")
    private String province;

    @ApiModelProperty(value = "城市ID")
    @NotBlank(message = "省市不能为空")
    private String city;

    @ApiModelProperty(value = "区域ID")
    @NotBlank(message = "区域不能为空")
    private String district;

    @ApiModelProperty(value = "身份证号码")
    @NotBlank(message = "身份证号码不能为空")
    private String idCardNo;

    @ApiModelProperty(value = "身份证正面")
    @NotBlank(message = "请上传身份证正面照片")
    private String idCardPositive;



}
