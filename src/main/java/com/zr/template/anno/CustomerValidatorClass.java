package com.zr.template.anno;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

public class CustomerValidatorClass  implements ConstraintValidator<CustomerValidator,String> {

    private String[] values;

    @Override
    public void initialize(CustomerValidator validator) {
        this.values= validator.value();
    }

    // 当数据为"1"或者"2"时,校验通过,当参数为其他值时,参数校验失败,抛出参数校验异常
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        AtomicBoolean atomicValid = new AtomicBoolean(false);
        if (value ==null) {
            //当状态为空时使用默认值
            return true;
        }
        Stream.of(values).filter(x->x.equals(value)).findFirst().ifPresent(s -> atomicValid.set(true));
        return atomicValid.get();
    }
}
