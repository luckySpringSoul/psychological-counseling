package com.rys.request.admin;

import com.rys.request.RequestPage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OpinionContentQueryRequest extends RequestPage {

    @ApiModelProperty(name = "status",value = "1 未处理 2已处理")
    private Integer status;
}
