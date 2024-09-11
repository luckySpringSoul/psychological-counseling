package com.rys.request.staff;

import com.rys.request.RequestPage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OutWarehousingCondition extends RequestPage {

    @ApiModelProperty(name = "startTime",example = "2021-05-27",required = true,value = "开始时间")
    private String startTime;

    @ApiModelProperty(name = "endTime",example = "2021-05-28",required = true,value = "结束时间")
    private String endTime;

    private String id;






}
