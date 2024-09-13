package com.rys.request.user;

import com.rys.request.RequestPage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author wh-yiloutingfengyu
 * @version 1.0.0
 * @ClassName PherapistQueryRequest.java
 * @Description
 * @createTime 2024年09月08日 18:18:00
 */
@Data
@ApiModel("用户获取咨询师请求对象")
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class PherapistQueryRequest extends RequestPage {

    @ApiModelProperty("预约时间 格式为 yyyy-MM-dd")
    private String reserveTime;

    @ApiModelProperty("预约类目")
    private String category;

    @ApiModelProperty("指导师id")
    private Long id;

    @ApiModelProperty("咨询师手机号")
    private String phone;

    @ApiModelProperty("咨询师名称")
    private String name;


}
