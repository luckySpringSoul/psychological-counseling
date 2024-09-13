package com.rys.response.user;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author wh-yiloutingfengyu
 * @version 1.0.0
 * @ClassName ReserveTherapistRequest.java
 * @Description
 * @createTime 2024年09月08日 21:39:00
 */
@Data
public class ReserveTherapistRequest implements Serializable {

    @ApiModelProperty("指导师id")
    @NotNull(message = "请选择对应的指导师！")
    private Long therapistId;

    @ApiModelProperty("预约时间")
    @NotNull(message = "请选择预约时间！")
    private String reserveTime;

}
