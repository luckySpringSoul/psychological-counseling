package com.rys.request.admin;

import com.rys.request.RequestPage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserListQueryRequest extends RequestPage implements Serializable {


    @ApiModelProperty(value = "用户手机号")
    private String userTel;


    @ApiModelProperty(value = "微信昵称")
    private String nickName;


    @ApiModelProperty(value = "加入开始时间  格式yyyy-MM-dd")
    private String startTime;


    @ApiModelProperty(value = "加入结束时间  格式yyyy-MM-dd")
    private String endTime;
}
