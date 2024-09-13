package com.rys.response.outwarehousing;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class WebOutWarehousingResponse {

    @ApiModelProperty(value = "出入库id")
    private Long code;

    @ApiModelProperty(value = "回收员编号")
    private String staffNo;

    @ApiModelProperty(value = "回收员ID")
    private Long staffId;

    @ApiModelProperty(value = "回收员姓名")
    private String staffName;

    @ApiModelProperty(value = "回收员电话")
    private String staffPhone;

    @ApiModelProperty(value = "1 纸品类 2 塑料类 3金属类 4其他类   多选字符串")
    private String goodsType;

    @ApiModelProperty(value = "货物重量")
    private BigDecimal goodsWeight;

    @ApiModelProperty(value = "交货时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime createTime;

    @ApiModelProperty(value = "入库有回购金额")
    private BigDecimal buyBackMoney;

    @ApiModelProperty(value = "出入库1分拣中心入库  2回收员交货  3出库")
    private Boolean type;

    @ApiModelProperty(value = "操作人")
    private String operator;

    @ApiModelProperty(value = "操作人ID")
    private Long operatorId;


}
