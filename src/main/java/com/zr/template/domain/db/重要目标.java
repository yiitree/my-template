package com.zr.template.domain.db;

import lombok.Data;

/**
 * @Author: 曾睿
 * @Date: 2020/7/22 09:49
 */
@Data
public class 重要目标 {

    int ID;
    String 名称;
    String 图层分类;
    String 分类代码;
    String 地址;
    String 目标性质;
    String 所属区县;
    String 所属街镇;
    String 联系人;
    String 联系电话;
    String 数据采集时间;
    String lon;
    String lat;

}
