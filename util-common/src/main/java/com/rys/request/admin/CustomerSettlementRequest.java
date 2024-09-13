package com.rys.request.admin;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
public class CustomerSettlementRequest implements Serializable {


    @ApiModelProperty(name = "codes",required = true,value = "主键code列表")
    @NotNull(message = "传入结算列code不能为空！")
    private List<Integer> codes;
}
