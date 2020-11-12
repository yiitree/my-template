package com.zr.template.mybatisplus;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.Scanner;

public class CodeGenerator {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        // 获取用户程序当前路径（项目根的路径）默认不用修改
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        // 作者
        gc.setAuthor("zr");
        // 当代码生成完成之后是否打开代码所在的文件夹
        gc.setOpen(false);
        // 实体属性 Swagger2 注解
        gc.setSwagger2(true);
        //生成service接口前面没有I（默认为IUserService）
        gc.setServiceName("%sService");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/uori?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        mpg.setDataSource(dsc);

        // 生成文件的位置信息
        // 配置
        PackageConfig pc = new PackageConfig();
        // 模块位置   com.xx.sys
        pc.setParent("com.xxx");
        pc.setModuleName("sys");
        // 选择生成那些内容（包位置） com.xx.sys.controller...
        pc.setController("controller");
        pc.setEntity("domain");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setMapper("mapper");
        // xml文件位置
        pc.setXml("mapper.xml");
        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //1、设置字段和表名的是否把下划线转化为驼峰命名规则
        // 表名
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 字段
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);

        //2、是否启动lombok
        strategy.setEntityLombokModel(true);
        //3、是否生成resetController
        strategy.setRestControllerStyle(true);
//        //4、controller继承的父类
//        strategy.setSuperControllerClass("com.xxx.BaseController");
//        //5、domain继承的父类
//        strategy.setSuperEntityClass("com.xxx.BaseEntity");
//        // 把表中字段进行忽略，认为父类中已有（与上面继承连用）
//        strategy.setSuperEntityColumns("user_id","name");

        // 设置表的前缀---生成表的时候忽略前缀
//        strategy.setTablePrefix("sys_");
        // 要设置生成哪些表 如果不设置就是生成所有的表
//        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        // 设置要生成的表(不设置这个属性表示全部生成)
//        strategy.setInclude("sys_aaa");

        //应用
        mpg.setStrategy(strategy);
        mpg.execute();
    }

}
