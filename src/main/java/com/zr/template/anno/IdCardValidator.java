package com.zr.template.anno;

import com.zr.template.util.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Author: 曾睿
 * @Date: 2020/10/12 20:08
 */
public class IdCardValidator implements ConstraintValidator<IdCard, String> {

    // 设置默认值
    private String[] values;

    // 是否必须传递
    private boolean require = false;

    /**
     * 设置默认值
     * @param constraint
     */
    @Override
    public void initialize(IdCard constraint) {
        this.values= constraint.value();
        this.require = constraint.required();
    }

   @Override
   public boolean isValid(String value, ConstraintValidatorContext context) {
//       AtomicBoolean atomicValid = new AtomicBoolean(false);
//       if (value == null) {
//           //当状态为空时使用默认值
//           return true;
//       }
//       Stream.of(values).filter(x->x.equals(value)).findFirst().ifPresent(s -> atomicValid.set(true));
//       return atomicValid.get();


       // 校验方法，value为传递值，返回boolean
       if(require){
           return ValidatorUtils.isMobile(value);
       }else {
           if (StringUtils.isEmpty(value)) {
               return true;
           }else {
               return ValidatorUtils.isMobile(value);
           }
       }

   }



}
