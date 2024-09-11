package com.rys.request;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author wh-yiloutingfengyu
 * @version 1.0.0
 * @ClassName TherapistQueryReq.java
 * @Description TODO
 * @createTime 2024年09月10日 17:42:00
 */
@Data
public class TherapistQueryReq extends RequestPage implements Serializable {

    private Long id;

    @ApiModelProperty("咨询师姓名")
    private String name;

    @ApiModelProperty("登陆密码")
    private String password;

    @ApiModelProperty("专业")
    private String specialization;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("可预约开始时间")
    private LocalDateTime appointmentStartTime;

    @ApiModelProperty("可预约结束时间")
    private LocalDateTime appointmentEndTime;

    private Integer status;

    @ApiModelProperty("性别 0男1女")
    private Integer gender;


}
