package com.rys.request.admin;

import com.rys.request.RequestPage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class NoticeQueryRequest extends RequestPage implements Serializable  {

    @ApiModelProperty(name = "title",required = false,value = "公告标题")
    private String title;


    @ApiModelProperty(name = "targetRole",required = false,value = "目标角色：0-全部、1 回收员  2地推员工  3销售员工")
    private Integer targetRole;

    @ApiModelProperty(name = "valid",value = "是否生效 0否1是")
    private Integer valid;
}
