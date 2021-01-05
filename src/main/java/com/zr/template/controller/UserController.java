package com.zr.template.controller;

import com.zr.template.common.RespBean;
import com.zr.template.domain.dto.UserDTO;
import com.zr.template.exception.CommonException;
import com.zr.template.exception.ExceptionEnum;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 曾睿
 * @Date: 2020/10/12 16:54
 */
@RestController
public class UserController {

    // 要加上@Validated，否则不起作用
    @PostMapping("/user")
    public RespBean userRegister(@RequestBody @Validated UserDTO userDTO){
        if(true){
            throw new CommonException(ExceptionEnum.NAME_CANNOT_BE_NULL);
        }
        return RespBean.ok("查询成功",userDTO);
    }

    // 要加上@Validated，否则不起作用
    @PostMapping("/x")
    public RespBean user(@RequestBody @Validated UserDTO userDTO){
        return RespBean.ok("查询成功",userDTO);
    }

}
