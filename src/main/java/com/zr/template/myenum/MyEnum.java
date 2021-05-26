package com.zr.template.myenum;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: 曾睿
 * @Date: 2021/5/26 09:35
 */
@Getter
@AllArgsConstructor // 只要提供全参构造
public enum MyEnum {
    // 每一个相当于是一个写好参数的默认构造函数，然后直接调用返回对象，
    // 和class类型使用方法唯一的区别就是不用传递构造函数，相当于提供了几个已经赋值的构造方法

    /** 张三 */
    ZS("zs",10,"北京"),
    /** 王五 */
    WW("ww",11,"上海"),
    /** 李四 */
    LS("ls",12,"广州"),
    ;

    private final String name;
    private final int age;
    private final String addr;
}

class Demo{
    public static void main(String[] args) {
        // 相当于使用默认构造函数，构造了一个对象
        MyEnum zs = MyEnum.ZS;
        zs.getName();
        zs.getAge();
        zs.getAddr();
    }
}
