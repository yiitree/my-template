package com.zr.template.domain.db;

import lombok.Data;

/**
 * @Author: 曾睿
 * @Date: 2020/7/22 09:45
 */
@Data
public class 警报器 {

    int ID;
    String 警报点名称;
    String 警报点编号;
    String 图层分类;
    String 分类代码;
    String 隶属单位;
    String 警报器型号;
    String 警报器功率;
    String 安装位置;
    String 安装高度;
    String 安装时间;
    String 音响覆盖半径;
    String 控制方式;
    String 设备状况;
    String 设点单位;
    String 设点单位地址;
    String 设点单位负责人;
    String 设点单位负责人联系电话;
    String 维护管理部门;
    String 维护管理负责人;
    String 维护管理负责人电话;
    String 所属区县;
    String 所属街镇;
    String 数据采集时间;
    String lon;
    String lat;

}
