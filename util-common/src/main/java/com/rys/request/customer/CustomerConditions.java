package com.rys.request.customer;

import com.rys.request.RequestPage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerConditions extends RequestPage {

    @ApiModelProperty(hidden = true)
    private String id;

    @ApiModelProperty(name = "status",example = "1",required = true,value = "审核状态 1待审核 2审核成功 3审核失败")
    private String status;

    @ApiModelProperty(name = "time",example = "2021-05-25",required = true,value = "筛选时间")
    private String time;
}
