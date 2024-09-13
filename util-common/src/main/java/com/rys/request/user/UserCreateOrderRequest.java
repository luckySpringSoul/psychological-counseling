package com.rys.request.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ApiModel(value="用户创建订单对象", description="用户创建订单对象")
public class UserCreateOrderRequest implements Serializable {

    @ApiModelProperty(value = "用户姓名")
    @NotBlank(message = "请填写用户姓名")
    private String userName;

    @ApiModelProperty(value = "用户联系电话")
    @NotBlank(message = "请填写用户电话")
    private String userTel;

    @ApiModelProperty(value = "用户ID")
    private Integer userId;
    @ApiModelProperty(value = "省ID")
    @NotBlank(message = "请选择具体省份")
    private String province;

    @ApiModelProperty(value = "城市ID")
    @NotBlank(message = "请选择具体市")
    private String city;

    @ApiModelProperty(value = "区ID")
    @NotBlank(message = "请选择具体区域")
    private String district;

    @ApiModelProperty(value = "自动定位的地址")
    private String address;

    @ApiModelProperty(value = "手动填写的详细地址")
    private String detailedAddress;

    @ApiModelProperty(value = "横坐标")
    @NotBlank(message = "经纬度不能为空")
    private String mapLon;

    @ApiModelProperty(value = "纵坐标")
    @NotBlank(message = "经纬度不能为空")
    private String mapLat;

    @ApiModelProperty(value = "订单类型 1 回收订单 2 公益订单")
    private Integer orderType;

    @ApiModelProperty(value = "1 纸品类 2 塑料类 3金属类 4其他类")
    private Integer goodsType;

    @ApiModelProperty(value = "物品类型  废纸类，金属类型， 公益类型：手表，电脑")
    private String goodsTypeName;

    @ApiModelProperty(value = "用户预估重量1:10-25KG  2:25-50KG 3:50-250KG 4:250KG以上")
    private Integer goodsWeight;

    @ApiModelProperty(value = "货物图片")
    private String imgUrl1;

    @ApiModelProperty(value = "货物图片")
    private String imgUrl2;

    @ApiModelProperty(value = "货物图片")
    private String imgUrl3;

    @ApiModelProperty(value = "订单备注")
    private String remark;

    @ApiModelProperty(value = "预约时间")
    private String appointmentTime;

    @ApiModelProperty(value = "1:指派模式,2:区域模式抢单,3:抢单模式")
    private Integer receiveType;

}
