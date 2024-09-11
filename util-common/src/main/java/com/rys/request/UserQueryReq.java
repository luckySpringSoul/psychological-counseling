package com.rys.request;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * @author wh-yiloutingfengyu
 * @version 1.0.0
 * @ClassName UserQueryReq.java
 * @Description
 * @createTime 2024年09月10日 09:58:00
 */
@Data
public class UserQueryReq extends RequestPage implements Serializable {

    @ApiModelProperty("用户id")
    private Long id;

    @ApiModelProperty("用户、咨询师姓名")
    private String name;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("角色类型")
    private Integer roleType;

    @ApiModelProperty("预约时间 格式为 yyyy-MM-dd 查询咨询师时可填入")
    private String reserveTime;

    @ApiModelProperty("预约类目 查询咨询师时可填入")
    private String category;


}
