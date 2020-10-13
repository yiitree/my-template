package com.zr.template.mybatisplus;

import com.zr.template.domain.User;
import com.zr.template.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @Author: 曾睿
 * @Date: 2020/9/16 15:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Add {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void addUser() {
        //设置自增后传不传id都一样，会忽略
        userMapper.insert(new User(null,"小明明","浦东",new Date()));
    }
}
