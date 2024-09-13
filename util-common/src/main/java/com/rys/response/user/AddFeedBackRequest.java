package com.rys.response.user;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * @author wh-yiloutingfengyu
 * @version 1.0.0
 * @ClassName AddFeedBackRequest.java
 * @Description
 * @createTime 2024年09月09日 18:49:00
 */
@Data
public class AddFeedBackRequest implements Serializable {

    @ApiModelProperty("指导师id")
    private Long therapistId;

    @ApiModelProperty("预约记录id")
    private Long appointmentId;

}
