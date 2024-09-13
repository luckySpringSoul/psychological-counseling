package com.rys.request.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@ApiModel(value="用户取消订单请求", description="用户取消订单请求")
public class UserCancelOrderRequest implements Serializable {

    @ApiModelProperty(value = "订单编号")
    @NotBlank(message = "订单编号不能为空")
    private String orderId;

    @ApiModelProperty(value = "1待接单  2已接单  3已完成 4已撤销")
    private String reason;

    @ApiModelProperty(value = "用户id")
    private Integer userId;
}
