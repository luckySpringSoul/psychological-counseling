package com.rys.response.staff;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class SubmitGoodsStatistic {

    @ApiModelProperty(value = "累计收益")
    private BigDecimal totalProfit;

    @ApiModelProperty(value = "累计重量")
    private BigDecimal totalWeight;

    @ApiModelProperty(value = "交货次数")
    private Integer submitTime;

}
