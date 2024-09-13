package com.rys.request.staff;

import com.rys.request.RequestPage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FindReceiveConditions extends RequestPage {

    @ApiModelProperty(name = "receiveName",value = "回收员姓名")
    private String receiveName;

    @ApiModelProperty(name = "receivePhone",value = "回收员电话")
    private String receivePhone;

    @ApiModelProperty(name = "userId",value = "用户id")
    private String userId;

    @ApiModelProperty(name = "orderId",value = "订单id")
    private String orderId;
}
