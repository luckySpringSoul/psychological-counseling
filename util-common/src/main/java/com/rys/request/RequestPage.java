package com.rys.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author lhy
 * @Description 分页工具
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestPage {

    /**
     * 当前页数
     */
    @NotNull(message = "pageCurrent不能为空")
    @ApiModelProperty(name = "pageCurrent", example = "1", required = true, value = "当前页")
    protected Integer pageCurrent = 1;

    /**
     * 每页个数
     */
    @NotNull(message = "pageSize不能为空")
    @ApiModelProperty(name = "pageSize", example = "10", required = true, value = "一页数量")
    protected Integer pageSize = 10;
}
