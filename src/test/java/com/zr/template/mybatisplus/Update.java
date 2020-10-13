package com.zr.template.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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
public class Update {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据主键修改
     */
    @Test
    private void updateUser() {
        userMapper.updateById(new User(112, "大明明", "武汉", new Date()));
    }

    /**
     * 根据查询条件修改
     */
    @Test
    public void update2(){
        UpdateWrapper<User> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("name", "小明");  //sql  ===where name="小明"
        updateWrapper.between("id", 10, 20);
        userMapper.update(new User(112, "小明", "武汉", new Date()), updateWrapper);
    }

}
