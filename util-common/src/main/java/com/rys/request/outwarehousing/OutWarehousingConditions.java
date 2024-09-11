package com.rys.request.outwarehousing;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rys.request.RequestPage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
    public class OutWarehousingConditions extends RequestPage {

    @ApiModelProperty(value = "回收员编号")
    private String staffNo;

    @ApiModelProperty(value = "回收员电话")
    private String staffPhone;

    @ApiModelProperty(value = "开始时间",example = "2021-5-31")
    public String startTime;

    @ApiModelProperty(value = "结束时间",example = "2021-6-31")
    public String endTime;




}
