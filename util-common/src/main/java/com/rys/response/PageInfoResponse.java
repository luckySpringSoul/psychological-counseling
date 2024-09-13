package com.rys.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageInfoResponse<T> implements Serializable {

        @ApiModelProperty(value = "当前页")
        private long current;
        @ApiModelProperty(value = "总条数")
        private long total;
        @ApiModelProperty(value = "页数")
        private long pages;
        @ApiModelProperty(value = "数据")
        private List<T> records;

}
