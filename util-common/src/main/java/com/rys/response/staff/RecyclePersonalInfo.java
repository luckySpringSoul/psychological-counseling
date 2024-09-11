package com.rys.response.staff;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class RecyclePersonalInfo {

    @ApiModelProperty(value = "累计接单")
    private Integer totalReceiveOrderCount;

    @ApiModelProperty(value = "累计重量")
    private Double totalWeight;

    @ApiModelProperty(value = "累计金额")
    private Double totalProfit;
}
