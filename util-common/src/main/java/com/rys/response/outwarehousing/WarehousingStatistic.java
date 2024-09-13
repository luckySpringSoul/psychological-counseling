package com.rys.response.outwarehousing;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class WarehousingStatistic {

    @ApiModelProperty(value = "出款金额")
    private BigDecimal totalProfit;

    @ApiModelProperty(value = "货物重量")
    private BigDecimal totalWeight;

}
