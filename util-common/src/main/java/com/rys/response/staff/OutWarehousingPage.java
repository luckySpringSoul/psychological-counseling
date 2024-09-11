package com.rys.response.staff;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OutWarehousingPage<T> {

    @ApiModelProperty(value = "当前页")
    private long current;
    @ApiModelProperty(value = "总条数")
    private long total;
    @ApiModelProperty(value = "页数")
    private long pages;
    @ApiModelProperty(value = "数据")
    private List<T> records;
    @ApiModelProperty(value = "收益")
    private Double profit;
    @ApiModelProperty(value = "重量")
    private Double weight;
    @ApiModelProperty(value = "次数")
    private Long time;

}
