package com.rys.response.admin;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class NoticeListResponse implements Serializable {

    @ApiModelProperty(value = "主键code")
    private Integer code;

    @ApiModelProperty(value = "公告标题")
    private String title;

    @ApiModelProperty(value = "公告内容")
    private String content;

    @ApiModelProperty(value = "目标角色：0-全部、1 回收员  2地推员工  3销售员工")
    private Integer targetRole;


    @ApiModelProperty(value = "已读次数")
    private Integer readCount;

    @ApiModelProperty(value = "展示位置。0首页。1其他")
    private Integer showType;

    @ApiModelProperty(value = "过期时间")
    private String expireTime;


    @ApiModelProperty(value = "生效时间")
    private String gmtRelease;


    @ApiModelProperty(value = "创建时间")
    private String createTime;
}
