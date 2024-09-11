package com.rys.response.user;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * @author wh-yiloutingfengyu
 * @version 1.0.0
 * @ClassName SessionResp.java
 * @Description
 * @createTime 2024年09月09日 19:31:00
 */
@Data
public class SessionResp implements Serializable {

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("用户姓名")
    private String userName;

    @ApiModelProperty("指导师id")
    private Long therapistId;

    @ApiModelProperty("指导师姓名")
    private String therapistName;

    @ApiModelProperty("会话时间")
    private String sessionTime;

    @ApiModelProperty("用户手机号")
    private String phone;
}
