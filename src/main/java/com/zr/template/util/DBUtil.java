package com.zr.template.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DBUtil {

    private static final Logger logger = LoggerFactory.getLogger(DBUtil.class);
    private static Connection connection = null;
    private static Statement statement = null;
    private static String username = "kanyun";
    private static String password = "kanyun";

    /**
     * @describe: 设置连接 * @params: * @Author: Kanyun * @Date: 2018/7/12 9:54
     */
    public static void setConnection() {
        try {
//            声明驱动类型
            Class.forName("org.sqlite.JDBC");
//            设置sqlite db文件存放基本目录
            String path = DBUtil.class.getClassLoader().getResource("").getPath();
            path = "E:\\opt\\web\\weijiandata\\file";

//            设置 sqlite文件路径，等同于mysql连接地址(jdbc:mysql://127.0.0.1:3306/test)
            String url = "jdbc:com.zr.template.sqlite:" + path + "data1.db";
            url = "jdbc:com.zr.template.sqlite:E:\\opt\\web\\weijiandata\\file\\民防办表单数据库-无数据.db";

//            获取连接
            connection = DriverManager.getConnection(url);
//            声明
            statement = connection.createStatement();
        } catch (Exception e) {
            throw new RuntimeException("建立Sqlite连接失败");
        }
    }

    /**
     * @describe: 创建表
     * @params: tableName: 要创建的表的名称 className：项目中Pojo的类名(需要注意的是该类名需要加上包名 如 com.xxx.xxx.pojo.xxx)
     * @Author: Kanyun
     * @Date: 2018/7/12 9:56
     */
    public synchronized static void create(String tableName, String className) {
        try {
            statement.executeUpdate("DROP TABLE IF EXISTS " + tableName + ";");
//            通过反射，获取传入类名的字段信息
            Field[] fields = Class.forName(className).getDeclaredFields();
            StringBuffer sb = new StringBuffer();
            String reg = " ";
            sb.append("create table " + tableName + " (");
            for (Field field : fields) {
//                设置使用反射时,可以访问私有变量,当pojo的变量设置为private修饰时,isAccessible()得到的值是false，必须要改成true才可以访问
                field.setAccessible(true);
//                通过获得的字段,获取字段类型,和字段名,来定义创建表的字段名和字段类型
                if (field.getType().getName().equals(Long.class.getName())) {
                    sb.append(reg + field.getName() + " bigint(20) ");
                } else if (field.getType().getName().equals(String.class.getName())) {
                    sb.append(reg + field.getName() + " varchar(255) ");
                } else if (field.getType().getName().equals(java.util.Date.class.getName())) {
                    sb.append(reg + field.getName() + " datetime ");
                } else {
                    sb.append(reg + field.getName() + " int(11) ");
                }
                reg = ",";
            }
            sb.append(") ;");
            statement.executeUpdate(sb.toString());
        } catch (Exception e) {
            logger.error("建表失败：" + e);
            System.out.println(e.toString());
            throw new RuntimeException("建表失败，表名称：" + tableName);
        }
    }

    /**
     * @describe: 表中插入数据
     * @params: tableName：表名 list:待插入的对象集合 需要注意的是插入的对象要跟表名对应
     * @Author: Kanyun
     * @Date: 2018/7/12 10:03
     */
    public synchronized static <T> int insert(String tableName, List<T> list) {
        StringBuffer declaration = new StringBuffer();
        List<String> dataSqlArray = new ArrayList<>();
        int count = 0;
        try {
            list.stream().map(t -> {
                if (dataSqlArray.size() < 1) {
                    logger.info("定义语句");
                    Field[] fields = t.getClass().getDeclaredFields();
                    declaration.append(" (");
                    String reg = "";
                    for (Field field : fields) {
                        field.setAccessible(true);
                        declaration.append(reg + field.getName());
                        reg = ",";
                    }
                    declaration.append(")");
                }
                return t;
            }).forEach((t) -> {
                Field[] fields = t.getClass().getDeclaredFields();
                StringBuffer oneData = new StringBuffer();
                String reg = "";
                oneData.append(" (");

                for (Field field : fields) {
                    try {
                        field.setAccessible(true);
                        if (null == field.get(t) || "".equals(field.get(t))) {
                            oneData.append(reg + null);
                        } else if (field.getType().getName().equals(String.class.getName())) {
//                            传入的对象中字段是字符串时,插入数据库需要转义单引号
                            oneData.append(reg + "\'" + field.get(t) + "\'");
//                            传入的对象中字段是日期类型时,先将日期转换为 yyyy-MM-dd 的形式(我这里,传入对象的日期对象格式为：Wed Jul 11 14:34:07 CST 2018),在将其转换成字符串，注意转义单引号
                        } else if (field.getType().getName().equals(java.util.Date.class.getName())) {
                            String dd = field.get(t).toString();
                            SimpleDateFormat sdf1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
                            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            String date = sdf2.format(sdf1.parse(dd));
                            oneData.append(reg + "\'" + date + "\'");
                        } else {
                            oneData.append(reg + field.get(t));
                        }
                        reg = ",";
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                oneData.append(")");
                dataSqlArray.add(oneData.toString());
            });
            String dataSql = StringUtils.join(dataSqlArray, ",");
            String retSQL = "INSERT INTO " + tableName + declaration.toString()
                    + " VALUES " + dataSql + ";";
            System.out.println(retSQL);
            PreparedStatement prep = connection.prepareStatement(retSQL);
//            设置自动提交
            connection.setAutoCommit(true);
            count = prep.executeUpdate();
        } catch (Exception e) {
            logger.error("插入失败：" + e);
            e.printStackTrace();
        }
        return count;
    }

    /**
     * @describe: 关闭链接
     * @params:
     * @Author: Kanyun
     * @Date: 2018/7/12 10:11
     */
    public static void endConnection() {
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
