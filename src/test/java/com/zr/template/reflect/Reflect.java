package com.zr.template.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author Jerry.Zeng
 * @date 2021/12/14
 */
public class Reflect {

    /**
     * 获取反射类
     * 三种方式
     */
    @Test
    public void test1(){
        // ================= 1.类对象.getClass() =================
        Person p = new Person();
        Class<?> class1 = p.getClass();
        System.out.println(class1);

        //  ================= 2.类.class() =================
        Class<?> class2 = Person.class;
        System.out.println(class2);

        //  ================= 3.Class.forName("全限定类名") =================
        // --此方法把类加载进内存（类中静态代码块不会执行，原因：静态代码块在类加载进内存后，使用前，初始化的类操作的时候执行）
        try {
            Class<?> class3 = Class.forName("com.zr.template.reflect.Person");
            System.out.println(class3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取反射类的信息
     */
    @Test
    public void test2(){
        // ================ 1.类修饰符 =================
//        0--默认不写 1--public 2--private 4--protected
//        8--static 16--final 32--synchronized
//        64--volatile 128--transient 256--native
//        512--interface 1024--abstract
        Class<?> clazz = Person.class;
        // 类的修饰符 int表示 1
        int mod = clazz.getModifiers();
        // 把int格式转化为String格式 public
        String str = Modifier.toString(mod);
        System.out.println(str);

        //  ================= 2.类名 =================
        // 全限定类名 com.zr.template.reflect.Person
        String name = clazz.getName();
        System.out.println(name);
        // 简易类名 Person
        String simpleName = clazz.getSimpleName();
        System.out.println(simpleName);

        // ================= 3.包名 =================
        Package aPackage = clazz.getPackage();
        System.out.println(aPackage.getName());

        //  ================= 4.父类 =================
        Class<?> sc = clazz.getSuperclass();
        System.out.println(sc.getName());

        //  ================= 5.接口 =================
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface.getName());
        }
    }

    /**
     * 创建对象
     */
    @Test
    public void test3() throws Exception {
        // ================= 使用无参构造 =================
        Class<?> clazz = Person.class;
        Person p = (Person) clazz.newInstance();
        System.out.println(p);

        // ================= 指定构造 =================
        Constructor<?> constructor = clazz.getConstructor();
        Person p1 = (Person)constructor.newInstance();
        System.out.println(p1);

        Constructor<?> constructor1 = clazz.getConstructor(String.class, Integer.class,String.class,String.class);
        Person p2 = (Person)constructor1.newInstance("zs", 15,"a","b");
        System.out.println(p2);
    }

    /**
     * 获取成员变量
     */
    @Test
    public void test4(){
        // ================= 获取 public 成员变量 =================
        Class<?> clazz = Person.class;
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        // ================= 获取 所有 成员变量 =================
        Field[] fields1 = clazz.getDeclaredFields();
        for (Field field : fields1) {
            System.out.println(field.getName());
        }

    }

    /**
     * 获取方法
     */
    @Test
    public void test5() throws Exception {
        // 获取所有 public 方法
        Class<?> clazz = Person.class;
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        Method method = clazz.getMethod("printAll");        //获取单个的公开方法
        method.invoke(clazz.newInstance(),null);

        Method[] methods1 = clazz.getDeclaredMethods();    //获取所有方法
        for (Method method1 : methods1) {
            System.out.println(method1.getName());
        }

        Method method1 = clazz.getDeclaredMethod("printOne");    //获取单个所有的方法
        System.out.println(method1.getName());
    }

    /*
    　设置访问属性
　　　clz.setAccessible(true)　　//可访问

　　　clz.setAccessible(false)　　//不可访问

    //默认是false
　　 Field id = clz.getField("age"); //age字段　　
    id.setAccessible(true); //设为可访问
    id.setAccessible(false);    //设为不可访问


　　使用方法
　　　method.invoke(Object obj,Object... args)

　　　obj：如果是实例方法，则放个该方法的类对象给它

　　　obj：静态方法，写null

　　　args：方法的参数值，没有写null，或不写都行

　　　

    Method method = clz.getMethod("printAll");        //获取单个的公开方法
    method.invoke(clz.newInstance(),null);    //使用方法
　　　当然，这些都只是常用的，反射不仅仅是只有这些
     */
}
