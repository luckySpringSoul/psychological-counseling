package com.rys.response.staff;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import org.springframework.data.geo.Point;

@Data
public class StaffPosition {

    @ApiModelProperty(value = "回收员id")
    private Long receiverId;

    @ApiModelProperty(value = "回收员坐标")
    private Point point;
}
