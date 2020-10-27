package com.zr.template.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: 曾睿
 * @Date: 2020/10/27 11:24
 */
@Getter
@Setter
@AllArgsConstructor
public class CommonException extends RuntimeException {

    private ExceptionEnum exceptionEnum;

}
