package com.rys.entity.user.wechat;

import lombok.Data;
import lombok.ToString;

/**
 * @ClassName ErrorInfo
 * @Description TODO
 * @Author Administrator
 * @Date 2020/9/25
 * @Version 1.0.0
 */
@Data
@ToString
public class ErrorInfo {
    private int errcode;
    private String errmsg;
}
