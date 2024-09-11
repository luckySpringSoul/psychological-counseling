package com.rys.request.staff;

import com.rys.request.RequestPage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MarketStaffCondition extends RequestPage {

    @ApiModelProperty(value = "员工编号  如 CD10001")
    private String staffNo;

    @ApiModelProperty(value = "员工姓名")
    private String name;

    @ApiModelProperty(value = "员工电话")
    private String tel;

    @ApiModelProperty(value = "1正常 2禁用")
    private String status;

    @ApiModelProperty(value = "开始时间")
    public String startTime;

    @ApiModelProperty(value = "结束时间")
    public String endTime;
}
