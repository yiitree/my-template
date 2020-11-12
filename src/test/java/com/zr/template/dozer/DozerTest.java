package com.zr.template.dozer;

import com.zr.template.domain.dozer.StudentDomain;
import com.zr.template.domain.dozer.StudentVo;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: 曾睿
 * @Date: 2020/10/22 09:24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DozerTest {

    @Autowired
    private Mapper dozerMapper;


//    @Test
//    public void testDefault(){
//        StudentDomain studentDomain = new StudentDomain(1024L, "tan日拱一兵", 18, "13996996996");
//
//        StudentVo studentVo = dozerMapper.map(studentDomain, StudentVo.class);
//        log.info("StudentVo: [{}]", studentVo.toString());
//
//        studentVo.setAge(16);
//        log.info("StudentDomain: [{}]", dozerMapper.map(studentVo, StudentDomain.class));
//    }
//
//
//    @Test
//    public void testDifferentAddress(){
//        StudentDomain studentDomain = new StudentDomain(1024L, "tan日拱一兵", 18, "13996996996", "中国");
//
//        StudentVo studentVo = dozerMapper.map(studentDomain, StudentVo.class);
//        log.info("StudentVo: [{}]", studentVo.toString());
//    }
//
//
//    //Dozer 会隐式递归匹配所有 field，甚至集合
//    @Test
//    public void testCascadeObject(){
//        StudentDomain studentDomain = new StudentDomain(1024L, "tan日拱一兵", 18, "13996996996", "中国",null,null);
//
//        StudentVo studentVo = dozerMapper.map(studentDomain, StudentVo.class);
//        log.info("StudentVo: [{}]", studentVo.toString());
//    }


    //Dozer 会隐式递归匹配所有 field，甚至集合
    @Test
    public void testCascadeObject1(){
        StudentDomain studentDomain = new StudentDomain(1024L, "tan日拱一兵", 18, "13996996996", "中国",null,null,null);

        StudentVo studentVo = dozerMapper.map(studentDomain, StudentVo.class, "userFieldOneWay");

        log.info("StudentVo: [{}]", studentVo.toString());
    }

    @Test
    public void test2(){

        // 只能转化同名且同类型的
//        BeanUtils.copyProperties(旧,新);

        StudentDomain oldOne = new StudentDomain(1024L, "tan日拱一兵", 18, "13996996996", "中国",null,null,null);
        // studentDomain被复制的，，，new StudentDomain()新复制的
        StudentDomain newOne = new StudentDomain();
        BeanUtils.copyProperties(oldOne, newOne);
        System.out.println(newOne);
    }




}
