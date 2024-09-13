package com.rys.response.user.login;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author wh-yiloutingfengyu
 * @version 1.0.0
 * @ClassName AddUserRequest.java
 * @Description 新增用户请求
 * @createTime 2024年09月09日 18:38:00
 */
@Data
public class AddUserRequest implements Serializable {

    @ApiModelProperty("用户手机号")
    @NotEmpty(message = "手机号不能为空！")
    private String phone;

    @ApiModelProperty("用户名称")
    @NotEmpty(message = "名称不能为空")
    private String name;

    @ApiModelProperty("登陆密码")
    private String password;

    @ApiModelProperty("性别 0男 1女")
    private Integer gender = 0;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("可预约开始时间 咨询师创建填写")
    private LocalDateTime appointmentStartTime;

    @ApiModelProperty("可预约结束时间 咨询师创建填写")
    private LocalDateTime appointmentEndTime;

    @ApiModelProperty("用户类型 1用户 2咨询师")
    @NotNull(message = "角色类型不能为空！")
    private Long roleType;
    @ApiModelProperty("专业 咨询师创建填写")
    private String specialization;

    private Long id;

}
