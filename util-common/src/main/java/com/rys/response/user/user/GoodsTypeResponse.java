package com.rys.response.user.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * <p>
 * 废品类型表
 * </p>
 *
 * @author yiloutingfengyu
 * @since 2021-05-31
 */
@Data
@ApiModel(value="TGoodsType对象", description="废品类型表")
public class GoodsTypeResponse {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键code")
    private Integer code;

    @ApiModelProperty(value = "1级分类(纸品，金属，塑料)  2级分类(如：黄纸，花纸)")
    private Integer goodsClassify;

    @ApiModelProperty(value = "物品类型1废纸 2塑料 3 金属 4 其他家电类")
    private Integer goodsType;

    @ApiModelProperty(value = "分类名称")
    private String goodsTypeName;

    @ApiModelProperty(value = "物品名称")
    private String goodsName;

    @ApiModelProperty(value = "描述")
    private String goodsDesc;

    @ApiModelProperty(value = "物品回收单价")
    private BigDecimal price;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "1显示  2 不显示")
    private Integer status;


}
