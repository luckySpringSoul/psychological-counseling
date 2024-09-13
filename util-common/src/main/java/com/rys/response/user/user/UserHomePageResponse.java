package com.rys.response.user.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@ApiModel(value="用户首页对象", description="用户首页对象")
public class UserHomePageResponse implements Serializable {

    @ApiModelProperty(value = "用户ID")
    private Long userId;

    @ApiModelProperty(value = "成长值 下一订单成长值加10")
    private Integer growthValue;

    @ApiModelProperty(value = "积分")
    private Integer integral;

    @ApiModelProperty(value = "1 正常 2禁用")
    private Boolean status;

    @ApiModelProperty(value = "下单次数")
    private Long orderNo;

    @ApiModelProperty(value = "累计重量KG")
    private BigDecimal allWeight;
/*

    private List<>*/

}
