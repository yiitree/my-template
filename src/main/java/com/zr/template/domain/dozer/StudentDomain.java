package com.zr.template.domain.dozer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: 曾睿
 * @Date: 2020/10/21 17:01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDomain {

    // 身份ID
    private Long id;
    // 姓名
    private String name;
    // 年龄
    private Integer age;
    // 电话
    private String mobile;

    // 地址
    private String addr;

    // 地址
    private AddressDomain address;
    // 课程集合
    private List<CourseDomain> courses;

    // 入学日期 设置为"2019-09-01 10:00:00"
    private String entrollmentDate;
}
