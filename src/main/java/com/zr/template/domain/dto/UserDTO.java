package com.zr.template.domain.dto;

import com.zr.template.anno.CustomerValidator;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class UserDTO {

    /**用户名*/
    @NotBlank(message = "用户姓名不能为空")
    @NotNull(message = "用户姓名不能为空")
    private String userName;

    /**手机号*/
    @NotBlank(message = "手机号不能为空")
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp ="^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号格式有误")
    private String mobileNo;

    /**性别*/
    @NotNull(message = "性别不能为空")
    private Integer sex;

    /**年龄*/
    @NotNull(message = "年龄不能为空")
    private Integer age;

    /**邮箱*/
    @NotBlank(message = "邮箱不能为空")
    @NotNull(message = "邮箱不能为空")
    @Email(message = "邮箱格式错误")
    private String email;

    /**身份证*/
    @NotNull(message = "身份证号不能为空")
//    @IdCard(message = "身份证不合法")
    private String idCardNumber;

    /**
     * 测试传递值
     * 当数据为"1"或者"2"时,校验通过,当参数为其他值时,参数校验失败,抛出参数校验异常
     */
    @CustomerValidator(value = {"1","2"})
    private String value;

}
