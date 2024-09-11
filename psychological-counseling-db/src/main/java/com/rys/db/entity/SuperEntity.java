package com.rys.db.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author chenxh
 * @version 1.0
 * @date 2021/4/20 6:21 下午
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SuperEntity extends SuperDateEntity {

    @ApiModelProperty(value = "删除标识,1为正常生效,0为逻辑删除")
    @TableLogic(value = "1",delval = "0")
    public Integer deleted;

}
