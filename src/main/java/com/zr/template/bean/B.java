package com.zr.template.bean;

import com.zr.template.domain.User;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Data
@Configuration
public class B {

    private int a = 1;
    private int b = 1;

    public int get(int a){
        return a + 1;
    }

    @Bean
    public User get(){
        return new User(1, "小明明", "浦东", new Date());
    }

    @Bean(name = "aa")
    public A gets(){
        return new A(3,3);
    }

}
