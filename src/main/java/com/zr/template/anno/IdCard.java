package com.zr.template.anno;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @Author: 曾睿
 * @Date: 2020/10/12 20:07
 */
@Documented
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IdCardValidator.class) //指定校验方法
public@interface IdCard {

    // 是否必须传递
    boolean required() default true;

    // 设置传递值
    String[] value() default {};

    // 设置默认返回信息
    String message() default "身份证号码不合法";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
