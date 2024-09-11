package com.rys.request.order;

import com.rys.request.RequestPage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OrderConditions extends RequestPage {

    @ApiModelProperty(hidden = true)
    private String id;

    @ApiModelProperty(value = "1待接单  2已接单  3已完成 4已撤销")
    private String orderStatus;
}
