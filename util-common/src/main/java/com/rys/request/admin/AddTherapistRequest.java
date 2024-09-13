package com.rys.request.admin;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author wh-yiloutingfengyu
 * @version 1.0.0
 * @ClassName AddTherapistRequest.java
 * @Description
 * @createTime 2024年09月09日 20:02:00
 */
@Data
public class AddTherapistRequest implements Serializable {

    @ApiModelProperty("咨询师姓名")
    private String name;

    @ApiModelProperty("登陆密码")
    private String password;

    @ApiModelProperty("专业领域")
    private String specialization;

    @ApiModelProperty("登陆手机号")
    private String phone;

    @ApiModelProperty("可预约开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime appointmentStartTime;

    @ApiModelProperty("可预约结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime appointmentEndTime;

    @ApiModelProperty("性别 0男1女")
    private Integer gender;


}
