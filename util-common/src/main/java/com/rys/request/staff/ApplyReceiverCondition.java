package com.rys.request.staff;

import com.rys.request.RequestPage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ApplyReceiverCondition extends RequestPage {

    @ApiModelProperty(name = "receiveName",value = "回收员姓名")
    private String receiveName;

    @ApiModelProperty(name = "receivePhone",value = "回收员电话")
    private String receivePhone;

    @ApiModelProperty(name = "time",example = "2021-05-27",required = true,value = "开始时间")
    private String startTime;

    @ApiModelProperty(name = "time",example = "2021-05-28",required = true,value = "结束时间")
    private String endTime;
}
