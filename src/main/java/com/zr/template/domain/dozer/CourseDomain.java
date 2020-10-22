package com.zr.template.domain.dozer;


import lombok.Data;

@Data
public class CourseDomain {
    // 课程编码
    private String courseCode;
    // 课程Id
    private Integer courseId;
    // 课程名称
    private String courseName;
    // 老师名称
    private String teacherName;
}
