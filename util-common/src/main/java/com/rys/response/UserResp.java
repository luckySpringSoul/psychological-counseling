package com.rys.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wh-yiloutingfengyu
 * @version 1.0.0
 * @ClassName UserResp.java
 * @Description TODO
 * @createTime 2024年09月10日 16:49:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResp implements Serializable {

    /**
     * 主键ID
     */
    private Long id;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty("性别 0男1女")
    private Integer gender;

    @ApiModelProperty("专业")
    private String specialization;

    @ApiModelProperty("可预约开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime appointmentStartTime;

    @ApiModelProperty("可预约结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime appointmentEndTime;

    @ApiModelProperty("用户类型 1用户 2咨询师")
    private Long roleType;
}
