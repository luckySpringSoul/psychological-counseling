package com.rys.response;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * @author wh-yiloutingfengyu
 * @version 1.0.0
 * @ClassName ReserveResp.java
 * @Description
 * @createTime 2024年09月0 8日 21:52:00
 */
@Data
public class ReserveResp implements Serializable {

    @ApiModelProperty("预约记录id")
    private Long reserveId;

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("指导师id")
    private Long therapistId;

    @ApiModelProperty("指导师姓名")
    private String therapistName;

    @ApiModelProperty("用户姓名")
    private String userName;

    @ApiModelProperty("预约时间")
    private String reserveTime;

}
