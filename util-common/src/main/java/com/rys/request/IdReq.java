package com.rys.request;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author wh-yiloutingfengyu
 * @version 1.0.0
 * @ClassName IdReq.java
 * @Description
 * @createTime 2024年09月10日 18:42:00
 */
@Data
public class IdReq implements Serializable {

    @ApiModelProperty("对应记录的id")
    @NotNull(message = "id不能为空！")
    private Long id;
}
