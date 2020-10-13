package com.zr.template.domain.db;

import lombok.Data;

/**
 * @Author: 曾睿
 * @Date: 2020/7/22 09:52
 */
@Data
public class 主出入口 {

    int ID;
    String 名称;
    String 图层分类;
    String 所属类别;
    String 所属工程;
    String 楼层数;
    String 所属楼层;
    String 角度;
    String 出入口描述;
    String 所属区县;
    String 所属街镇;
    String 数据采集时间;
    String lon;
    String lat;

}
