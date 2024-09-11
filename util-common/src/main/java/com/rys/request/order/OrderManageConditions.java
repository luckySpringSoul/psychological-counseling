package com.rys.request.order;

import com.rys.request.RequestPage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OrderManageConditions extends RequestPage {



    @ApiModelProperty(value = "用户手机号")
    private String phone;

    @ApiModelProperty(value = "1待接单  2已接单  3已完成 4已撤销")
    private Integer orderStatus;

    @ApiModelProperty(value = "订单类型 1 回收订单 2 公益订单")
    private Integer orderType;

    @ApiModelProperty(value = "开始时间")
    private String startTime;

    @ApiModelProperty(value = "结束时间")
    private String endTime;

    @ApiModelProperty(value = "用户id")
    private Integer userId;
}
