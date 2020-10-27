package com.zr.template.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Author: 曾睿
 * @Date: 2020/10/27 10:25
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum {

    /**
     * 姓名不能为空
     */
    NAME_CANNOT_BE_NULL(400,"姓名不能为空!"),
    ;

    private int code;
    private String msg;
}
