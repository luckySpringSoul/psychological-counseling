package com.rys.utils.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @description: 业务异常
 * @author: binggui
 * @date: 2021-04-22 15:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BusinessException extends RuntimeException {

    private Integer code;

    private String message;

    public BusinessException(String message) {
        this.message = message;
    }
}