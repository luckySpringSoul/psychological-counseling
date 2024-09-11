package com.rys.request;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import java.io.Serializable;
import lombok.Data;

/**
 * @author wh-yiloutingfengyu
 * @version 1.0.0
 * @ClassName ReserveQueryReq.java
 * @Description
 * @createTime 2024年09月10日 17:44:00
 */
@Data
public class ReserveQueryReq extends RequestPage implements Serializable {


    @ApiModelProperty("指导师id")
    private Long therapistId;

    @ApiModelProperty("预约时间")
    private String reserveTime;

    @ApiModelProperty("用户id")
    private Long userId;

}
