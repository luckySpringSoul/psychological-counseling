package com.rys.response.order;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderManageDetail {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "订单编号")
    private Long code;

    @ApiModelProperty(value = "代理商ID")
    private Integer agentId;

    @ApiModelProperty(value = "员工编号  如 CD10001")
    private String staffNo;

    @ApiModelProperty(value = "回收员ID")
    private Integer staffId;

    @ApiModelProperty(value = "回收员姓名")
    private String staffName;

    @ApiModelProperty(value = "回收员电话")
    private String staffTel;

    @ApiModelProperty(value = "回收次数")
    private Integer receiveCount;

    @ApiModelProperty(value = "用户ID")
    private Integer userId;

    @ApiModelProperty(value = "用户姓名")
    private String userName;

    @ApiModelProperty(value = "用户联系电话")
    private String userTel;

    @ApiModelProperty(value = "下单次数")
    private Integer useTimes;

    @ApiModelProperty(value = "省ID")
    private String province;

    @ApiModelProperty(value = "城市ID")
    private String city;

    @ApiModelProperty(value = "区ID")
    private String district;

    @ApiModelProperty(value = "自动定位的地址")
    private String address;

    @ApiModelProperty(value = "手动填写的详细地址")
    private String detailedAddress;


    @ApiModelProperty(value = "订单类型 1 回收订单 2 公益订单")
    private Integer orderType;

    @ApiModelProperty(value = "1待接单  2已接单  3已完成 4已撤销")
    private Integer orderStatus;

    @ApiModelProperty(value = "1 纸品类 2 塑料类 3金属类 4其他类")
    private Integer goodsType;

    @ApiModelProperty(value = "物品类型  废纸类，金属类型， 公益类型：手表，电脑")
    private String goodsTypeName;

    @ApiModelProperty(value = "用户预估重量1:10-25KG  2:25-50KG 3:50-250KG 4:250KG以上")
    private Integer goodsWeight;

    @ApiModelProperty(value = "实际回收重量")
    private BigDecimal actualGoodsWeight;

    @ApiModelProperty(value = "实际回收金额")
    private BigDecimal recoveryAmount;

    @ApiModelProperty(value = "订单备注")
    private String remark;

    @ApiModelProperty(value = "预约时间")
    private LocalDateTime appointmentTime;

    @ApiModelProperty(value = "接单时间")
    private LocalDateTime meetOrderTime;

    @ApiModelProperty(value = "订单完成时间")
    private LocalDateTime completionTime;

    @ApiModelProperty(value = "1:指派模式,2:区域模式抢单,3:抢单模式")
    private Integer receiveType;

    @ApiModelProperty(value = "订单归属,目前只有平台")
    private String source;


}
