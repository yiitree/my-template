package com.zr.template.bean;

import com.zr.template.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Client {

    @Autowired
    A a;

    @Autowired
    B b;

    @Autowired
    User user;

    @Resource(name = "aa")
    A aa;

    @Test
    public void test(){
        System.out.println(a.getA());
        System.out.println(a.getB());
        System.out.println(a.get(3));

        System.out.println(b.get());

        System.out.println(user);

        System.out.println(aa);

    }

}
