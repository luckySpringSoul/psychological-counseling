package com.rys.request;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * @author wh-yiloutingfengyu
 * @version 1.0.0
 * @ClassName SessionQueryReq.java
 * @Description
 * @createTime 2024年09月10日 17:57:00
 */
@Data
public class SessionQueryReq extends RequestPage implements Serializable {

    @ApiModelProperty("会话id")
    private Long id;

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("咨询师id")
    private Long therapistId;

    @ApiModelProperty("会话时间 yyyy-MM-dd")
    private String sessionTime;

}
