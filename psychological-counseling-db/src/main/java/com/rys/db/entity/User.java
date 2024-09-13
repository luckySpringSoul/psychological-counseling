package com.rys.db.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.rys.response.UserResp;
import com.rys.utils.AesUtils;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author YourName
 * @since 2024-09-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_user")
@ApiModel(value = "User对象", description = "用户信息表")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id")
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
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
    private LocalDateTime appointmentStartTime;

    @ApiModelProperty("可预约结束时间")
    private LocalDateTime appointmentEndTime;

    @ApiModelProperty("用户类型 1用户 2咨询师")
    private Long roleType;

    public UserResp buildResp() {
        return UserResp.builder()
            .id(id)
            .createTime(createTime)
            .updateTime(updateTime)
            .phone(phone)
            .email(email)
            .status(status)
            .gender(gender)
            .email(email)
            .password(AesUtils.decrypt(password))
            .roleType(roleType)
            .specialization(specialization)
            .appointmentStartTime(appointmentStartTime)
            .appointmentEndTime(appointmentEndTime)
            .name(name)
            .build();

    }


}
