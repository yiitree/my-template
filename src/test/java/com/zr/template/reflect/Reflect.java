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
    public void test1() {
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
    public void test2() {
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
        Person p1 = (Person) constructor.newInstance();
        System.out.println(p1);

        Constructor<?> constructor1 = clazz.getConstructor(String.class, Integer.class, String.class, String.class, String.class);
        Person p2 = (Person) constructor1.newInstance("zs", 15, "a", "b", "c");
        System.out.println(p2);
    }

    /**
     * 获取方法
     */
    @Test
    public void test5() throws Exception {
        Class<?> clazz = Person.class;
        // ================= 获取 public 方法 =================
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        // ================= 获取所有方法 =================
        Method[] methods1 = clazz.getDeclaredMethods();
        for (Method method1 : methods1) {
            System.out.println(method1.getName());
        }

        // 获取方法
        Method method1 = clazz.getDeclaredMethod("get");
        System.out.println(method1.getName());
        // 执行方法
        String a = (String) method1.invoke(clazz.newInstance());
        System.out.println(a);

        // 方法名 方法参数
        Method method2 = clazz.getDeclaredMethod("get1", String.class);
        System.out.println(method2.getName());
        // 创建一个实例 传参
        String aa = (String) method2.invoke(clazz.newInstance(), "bbb");
        System.out.println(aa);
    }

    /**
     * 获取成员变量
     */
    @Test
    public void test4() throws Exception {
        // ================= 获取 public 成员变量 =================
        Class<?> clazz = Person.class;
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        // ================= 获取所有成员变量 =================
        Field[] fields1 = clazz.getDeclaredFields();
        for (Field field : fields1) {
            System.out.println(field.getName());
        }

        // ================= 获取指定成员变量 =================
        Field field = clazz.getDeclaredField("name");
        // ================= 设置字段的修饰符（防止有些private无法设置） =================
        field.setAccessible(true);
        // ================= 设置字段的属性（防止有些private无法设置） =================
        Person p = new Person();
        field.set(p, "mingzi");

        setProperty(p, "age", 12);
        System.out.println(p);
    }

    /**
     * 设置对象的属性
     *
     * @param bean         对象
     * @param propertyName 要设置的属性名
     * @param value        要设置的值
     * @throws Exception
     */
    public void setProperty(Object bean, String propertyName, Object value) throws Exception {
        Class<?> clazz = bean.getClass();
        Field field = clazz.getDeclaredField(propertyName);
        field.setAccessible(true);
        field.set(bean, value);
    }

}
