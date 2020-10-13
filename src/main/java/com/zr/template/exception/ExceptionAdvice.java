package com.zr.template.exception;

import com.zr.template.common.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一处理所有异常
 * @Author: 曾睿
 * @Date: 2020/9/27 15:56
 */
@Slf4j
// 以子类为优先级拦截
@RestControllerAdvice("com.zr")//传入拦截范围
public class ExceptionAdvice {

    /**
     * 通用异常处理方法
     * 指定拦截exception的类型，不写会默认拦截传参的异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Object exceptionHandler(Exception e){
        log.error("服务器异常", e);
        return RespBean.error("服务器异常！",e.getMessage());
    }

    /**
     * 表示会拦截BindException，然后返回一个Object给客户端
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    public Object exceptionHandler(BindException e){
        log.error("参数校验异常", e);
        return RespBean.error("参数校验异常！",e.getMessage());
    }

    /**-------- 自定义定异常处理方法 --------**/
    @ExceptionHandler(FileStorageException.class)
    public Object exceptionHandler(FileStorageException e){
        log.error("文件上传异常", e);
        return RespBean.error("文件上传异常！",e.getMessage());
    }

    /**-------- 参数绑定异常处理方法 --------**/
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("参数传递异常", e);
        return RespBean.error(e.getBindingResult().getFieldError().getDefaultMessage());
    }

}
