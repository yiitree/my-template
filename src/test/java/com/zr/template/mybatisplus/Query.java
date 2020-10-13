package com.zr.template.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zr.template.domain.User;
import com.zr.template.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;
import java.util.*;

/**
 * @Author: 曾睿
 * @Date: 2020/9/16 15:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Query {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据id查询
     */
    @Test
    public void query1() {
        User user = userMapper.selectById(7);
        System.out.println(user);
    }

    /**
     * 根据idList查询
     */
    @Test
    public void query2() {
        Collection<Serializable> idList=new ArrayList<Serializable>();
        idList.add(3);
        idList.add(4);
        idList.add(5);
        List<User> list = userMapper.selectBatchIds(idList);
        print(list);
    }

    /**
     * 根据条件查询
     */
    @Test
    public void query3() {
        Map<String, Object> columnMap=new HashMap<>();
        columnMap.put("name", "大明明");
        columnMap.put("address", "武汉");
        List<User> list = userMapper.selectByMap(columnMap);
        print(list);
    }

    /**
     * 查询个数
     */
    @Test
    public void query4() {
        String name = "zs";
        Integer count = userMapper.selectCount(null);

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(name!=null, "name", name);

        // 等于
//		queryWrapper.ge(判断后面参数是否添加, , );
        Integer selectCount = userMapper.selectCount(queryWrapper);
        System.out.println(selectCount);
    }

    /**
     * 分页查询
     */
    @Test
    public void query5() {
        // 查询条件
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.between("id", 20, 21);



        // 分页条件（可以传一个null表示没有额外条件）
        IPage<User> page=new Page<>(2, 3);
        userMapper.selectPage(page, null);

        // 直接对原page进行赋值
        // 传入的条件
        // 当前页，默认 1
        long current = page.getCurrent();
        // 一页页数
        long size = page.getSize();

        // 返回条件
        // 总条数
        long total = page.getTotal();
        // 共多少页
        long pages = page.getPages();
        // 查询内容
        List<User> list = page.getRecords();

        // 传入的条件
        System.out.println("当前页:"+current);
        System.out.println("一页页数:"+size);

        // 返回条件
        System.out.println("总条数:"+total);
        System.out.println("共多少页:"+pages);
        print(list);
    }

    public static void print(List<User> list) {
        for (User user : list) {
            System.out.println(user);
        }
    }

}
