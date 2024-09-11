package com.rys.response.staff;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OutWarehousingResponse {

    @ApiModelProperty(value = "1 纸品类 2 塑料类 3金属类 4其他类   多选字符串")
    private String goodsType;

    @ApiModelProperty(value = "操作人")
    private String operator;

    @ApiModelProperty(value = "交货   时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime updateTime;

    @ApiModelProperty(value = "货物重量")
    private BigDecimal goodsWeight;


    @ApiModelProperty(value = "入库有回购金额")
    private BigDecimal buyBackMoney;

}
