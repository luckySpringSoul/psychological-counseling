package com.rys.response.order;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class MonthStatistic {

    @ApiModelProperty(value = "本月收货重量(kg)")
    private BigDecimal monthWeight;

    @ApiModelProperty(value = "本月新增回收员")
    private Integer newReceiver;

    @ApiModelProperty(value = "本月线上订单")
    private Integer monthOrderCount;



}
