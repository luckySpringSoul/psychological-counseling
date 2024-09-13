package com.rys.utils.exception;

import com.rys.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ValidationException;


/**
 * @description: 全局异常处理
 * @author: binggui
 * @date: 2021-04-22 13:40
 */
@Slf4j
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Result<?> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return Result.fail(objectError.getDefaultMessage());
    }

    @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
    public Result<?>HttpMediaTypeNotSupportedExceptionHandler(HttpMediaTypeNotSupportedException e) {
        Result<?> result = new Result();
        result.setCode(10008);
        result.setMsg("请求类型不支持");
        return result;
    }

    @ExceptionHandler({CommonException.class})
    public Result<?> commonExceptionHandler(CommonException commentException) {
        //提取错误提示信息进行返回
        Result<?> result = new Result();
        result.setCode(commentException.getCode());
        result.setMsg(commentException.getMessage());
        return result;
    }

    @ExceptionHandler({CommentException.class})
    public Result<?> commentExceptionHandler(CommentException commentException) {
        //提取错误提示信息进行返回
        Result<?> result = new Result();
        result.setCode(commentException.getCode());
        result.setMsg(commentException.getMessage());
        return result;
    }

    @ExceptionHandler({BusinessException.class})
    public Result<?> businessExceptionHandler(BusinessException businessException) {
        if (businessException.getCode() == null) {
            return Result.fail(businessException.getMessage());
        } else {
            return Result.fail(businessException.getCode(),businessException.getMessage());
        }
    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public Result<?> HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException httpRequestMethodNotSupportedException) {
        return Result.fail(httpRequestMethodNotSupportedException.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result<?> HttpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.error("HttpMessageNotReadableException：", e);
        return Result.fail("body请求参数未能注入到后台,请仔细检查相关参数");
    }

    @ExceptionHandler({ValidationException.class})
    public Result<?> validExceptionHandler(ValidationException e) {
        String message = e.getMessage();
        String resultMessage = message.substring(message.lastIndexOf(":") + 1).replaceAll("\\s*", "");
        return Result.fail(CommentExceptionEnum.SYSTEM_ERROR.getCode(), resultMessage);
    }

    /**
     * 参数校验异常捕获
     */
    @ExceptionHandler({BindException.class })
    public Result BindExceptionHandler(BindException e) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 然后提取错误提示信息进行返回
        return Result.fail(objectError.getDefaultMessage());
    }

    @ExceptionHandler({Exception.class})
    public Result<?> peakExceptionHandler(Exception e) {
        log.error("Exception：", e);
        return Result.fail(CommentExceptionEnum.SYSTEM_ERROR.getCode(), CommentExceptionEnum.SYSTEM_ERROR.getMessage());
    }
}
