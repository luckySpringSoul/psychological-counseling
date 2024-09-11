package com.rys.utils.exception;

/**
 * @Description
 * @Author lhy
 * @Date 2020/12/3
 * @Version 1.0.0
 */
public enum CommonExceptionEnum implements ServiceExceptionEnum {

    /**
     * 常见异常
     */
    SYSTEM_ERROR(-40000, "系统异常"),
    AUTH_ERROR(1002, "登录过期，请重新登录"),
    NOT_TOKEN_ERROR(-40002, "token获取失败"),
    NOT_AUTH_ERROR(-40003, "需要授权"),
    EXPIRE_ERROR(-40004, "token已过期"),
    SIGN_ERROR(-40005, "签名验证异常"),
    SIGN_ACCESS_ID(-40006, "签名验证参数 accessId 必传"),
    SIGN_TIMESTAMP(-40007, "签名验证参数 timestamp 必传"),
    SIGN_TIMESTAMP_INVALID(-40010, "timestamp 格式不正确"),
    SIGN_TIMESTAMP_EXPIRED(-40011, "timestamp 已过期"),
    SIGN_SIGN(-40008, "签名验证参数 sgin 必传"),
    SIGN_ACCESS_SECRET(-40009, "该 accessId 未找到对应 accessSecret, 请联系管理员"),
    NOT_TEMPLATEID_ERROR(-41001, "未获取到模板ID"),
    TEMPLATE_MSG_ERROR(-41002, "发送模板消息失败"),
    SIGNVERIFY_ERROR(-41003, "验签失败"),
    MAXPAGESIZE_ERROR(-41004, "页面个数太大，不能超过100");


    private Integer code;

    private String message;

    CommonExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
