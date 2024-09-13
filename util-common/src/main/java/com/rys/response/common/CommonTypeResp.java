package com.rys.response.common;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * @author wh-yiloutingfengyu
 * @version 1.0.0
 * @ClassName CommonTypeResp.java
 * @Description
 * @createTime 2024年09月08日 21:23:00
 */
@Data
public class CommonTypeResp implements Serializable {


    @ApiModelProperty("编码")
    private String code;

    @ApiModelProperty("描述")
    private String desc;

}
