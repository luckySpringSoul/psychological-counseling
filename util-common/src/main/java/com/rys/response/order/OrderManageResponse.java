package com.rys.response.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderManageResponse {


    @ApiModelProperty(value = "订单编号")
    private Long code;

    @ApiModelProperty(value = "订单类型 1 回收订单 2 公益订单")
    private Integer orderType;

    @ApiModelProperty(value = "1待接单  2已接单  3已完成 4已撤销")
    private Integer orderStatus;

    @ApiModelProperty(value = "1 纸品类 2 塑料类 3金属类 4其他类")
    private Integer goodsType;

    @ApiModelProperty(value = "用户预估重量1:10-25KG  2:25-50KG 3:50-250KG 4:250KG以上")
    private Integer goodsWeight;

    @ApiModelProperty(value = "区ID")
    private String district;

    @ApiModelProperty(value = "订单归属,目前只有平台")
    private String source;

    @ApiModelProperty(value = "1:指派模式,2:区域模式抢单,3:抢单模式")
    private Integer receiveType;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime createTime;

    @ApiModelProperty(value = "预约时间")
    private LocalDateTime appointmentTime;

    @ApiModelProperty(value = "用户联系电话")
    private String userTel;

    @ApiModelProperty(value = "用户姓名")
    private String userName;

}
