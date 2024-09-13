package com.rys.request.admin;

import com.rys.request.RequestPage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class GoodsTypeQueryRequest extends RequestPage {


    @ApiModelProperty(name = "goodsName",required = false,value = "物品名称")
    private String goodsName;

    @ApiModelProperty(name = "goodsClassify",required = false,value = "1级分类(纸品，金属，塑料)  2级分类(如：黄纸，花纸)',")
    private Integer goodsClassify;
}
