package com.rys.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 前段返回实体类
 *
 * @author chenxh
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    public static final int SUCCESS_CODE = 1000;
    public static final int FAIL_CODE = 1001;

    private int code;

    private String msg;

    private T data;


    public static <T> Result<T> success() {
        return new Result<>(SUCCESS_CODE, "操作成功", null);
    }

    public static <T> Result<T> success(String msg) {
        return new Result<>(SUCCESS_CODE, msg, null);
    }

    public static <T> Result<T> success(T data) {
        Result<T> success = success();
        success.setData(data);
        return success;
    }

    public static <T> Result<T> success(String msg, T data) {
        Result<T> success = success();
        success.setMsg(msg);
        success.setData(data);
        return success;
    }

    public static <T> Result<T> fail() {
        return new Result<>(FAIL_CODE, "操作失败", null);
    }

    public static <T> Result<T> fail(String msg) {
        Result<T> fail = fail();
        fail.setMsg(msg);
        return fail;
    }

    public static <T> Result<T> fail(T data) {
        Result<T> fail = fail();
        fail.setData(data);
        return fail;
    }

    public static <T> Result<T> fail(String msg, T data) {
        Result<T> fail = fail();
        fail.setMsg(msg);
        fail.setData(data);
        return fail;
    }

    public static <T> Result<T> fail(int code, String msg) {
        return new Result<>(code, msg, null);
    }

    public static <T> Result<T> subFail(Integer code, String msg) {
        return new Result<>(FAIL_CODE, "", null);
    }

    public boolean isSuccess() {
        return SUCCESS_CODE == this.code;
    }
}
