package com.rys.utils.exception;

/**
 * @Description
 * @Author lhy
 * @Date 2020/12/3
 * @Version 1.0.0
 */
public class CommentException extends RuntimeException {

    private Integer code;

    private String message;

    public CommentException(ServiceExceptionEnum serviceExceptionEnum) {
        this.code = serviceExceptionEnum.getCode();
        this.message = serviceExceptionEnum.getMessage();
    }

    /**
     * 参数校验异常构造方法
     */
    public CommentException(ServiceExceptionEnum serviceExceptionEnum, String message) {
        this.code = serviceExceptionEnum.getCode();
        this.message = message;
    }

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
