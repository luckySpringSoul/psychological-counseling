package com.rys.response.order;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class AdminTotalStatistic {

    @ApiModelProperty(value = "累计收货(kg)")
    private BigDecimal totalWeight;

    @ApiModelProperty(value = "回收员数量(个)")
    private Integer totalReceiveCount;

    @ApiModelProperty(value = "线上订单(笔))")
    private Integer totalOrderCount;
}
