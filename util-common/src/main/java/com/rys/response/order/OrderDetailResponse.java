package com.rys.response.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderDetailResponse {

    @ApiModelProperty(value = "订单id")
    private Long orderId;

    @ApiModelProperty(value = "下单时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime createTime;

    @ApiModelProperty(value = "1 纸品类 2 塑料类 3金属类 4其他类")
    private Integer goodsType;

    @ApiModelProperty(value = "用户预估重量1:10-25KG  2:25-50KG 3:50-250KG 4:250KG以上")
    private Integer goodsWeight;

    @ApiModelProperty(value = "自动定位的地址")
    private String address;

    @ApiModelProperty(value = "手动填写的详细地址")
    private String detailedAddress;

    @ApiModelProperty(value = "用户联系电话")
    private String userTel;

    @ApiModelProperty(value = "预约时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime appointmentTime;

    @ApiModelProperty(value = "货物图片")
    private String imgUrl1;

    @ApiModelProperty(value = "货物图片")
    private String imgUrl2;

    @ApiModelProperty(value = "货物图片")
    private String imgUrl3;

    @ApiModelProperty(value = "订单备注")
    private String remark;

    @ApiModelProperty(value = "实际回收重量")
    private BigDecimal actualGoodsWeight;

    @ApiModelProperty(value = "实际回收金额")
    private BigDecimal recoveryAmount;

    @ApiModelProperty(value = "1待接单  2已接单  3已完成 4已撤销")
    private Integer orderStatus;

    @ApiModelProperty(value = "用户姓名")
    private String userName;


    @ApiModelProperty(value = "横坐标")
    private String mapLon;

    @ApiModelProperty(value = "纵坐标")
    private String mapLat;




    private String staffId;


}
