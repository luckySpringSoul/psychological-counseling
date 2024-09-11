package com.rys.response.user.user;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * @author wh-yiloutingfengyu
 * @version 1.0.0
 * @ClassName AddSessionRequest.java
 * @Description
 * @createTime 2024年09月09日 19:26:00
 */
@Data
public class AddSessionRequest implements Serializable {

    @ApiModelProperty("指导师id")
    private Long therapistId;

}
