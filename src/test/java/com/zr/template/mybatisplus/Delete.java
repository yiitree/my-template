package com.zr.template.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zr.template.domain.User;
import com.zr.template.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 曾睿
 * @Date: 2020/9/16 15:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Delete {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据主键删除
     */
    @Test
    private void delete1() {
		userMapper.deleteById(111);
    }

    /**
     * 根据idList删除
     */
    @Test
    private void delete2() {
        Collection<Serializable> idList=new ArrayList<>();
//        List<Serializable> idList = new ArrayList<>();
        idList.add(115);
        idList.add(112);
        userMapper.deleteBatchIds(idList);
    }

    /**
     * 根据map条件删除
     */
    @Test
    private void delete3() {
        Map<String, Object> columnMap=new HashMap<>();
        columnMap.put("id", 6);
        columnMap.put("name", "小明");
        userMapper.deleteByMap(columnMap);
    }

    /**
     *根据设置条件删除
     */
    @Test
    private void delete4() {
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.between("id", 20, 21);
        userMapper.delete(wrapper);
    }

}
