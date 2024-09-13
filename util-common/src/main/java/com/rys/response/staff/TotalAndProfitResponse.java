package com.rys.response.staff;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TotalAndProfitResponse {


    @ApiModelProperty(name = "total",value = "总数量")
    private Integer total;

    @ApiModelProperty(name = "profit",value = "总收益")
    private BigDecimal profit;
}
