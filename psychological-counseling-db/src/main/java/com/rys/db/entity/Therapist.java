package com.rys.db.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author YourName
 * @since 2024-09-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_therapist")
@ApiModel(value = "Therapist对象", description = "")
public class Therapist implements Serializable {

    private static final long serialVersionUID = 1L;

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
