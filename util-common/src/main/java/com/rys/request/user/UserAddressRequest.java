package com.rys.request.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * <p>
 * 用户地址表
 * </p>
 *
 * @author yiloutingfengyu
 * @since 2021-05-31
 */
@Data
@ApiModel(value="TUserAddress对象", description="用户地址表")
public class UserAddressRequest implements Serializable {

    private static final long serialVersionUID=1L;

    private Long code;

    private Integer userId;

    @ApiModelProperty(value = "1默认 0否")
    private Integer isDefault;

    @ApiModelProperty(value = "联系人姓名")
    private String name;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "状态 1 正常 2禁用")
    private Boolean status;

    @ApiModelProperty(value = "省ID")
    private String province;

    @ApiModelProperty(value = "城市")
    private String city;

    @ApiModelProperty(value = "区域ID")
    private String district;

    @ApiModelProperty(value = "街道ID")
    private String street;

    @ApiModelProperty(value = "详细地址")
    private String address;

    @ApiModelProperty(value = "横坐标")
    @NotBlank(message = "经纬度不能为空")
    private String mapLon;

    @ApiModelProperty(value = "纵坐标")
    @NotBlank(message = "经纬度不能为空")
    private String mapLat;

    @ApiModelProperty(value = "纵坐标")
    @NotBlank(message = "定位地址不能为空")
    private String locateAddress;


}
