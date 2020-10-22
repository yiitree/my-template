package com.zr.template.config;

import com.zr.template.domain.dozer.AddressDomain;
import com.zr.template.domain.dozer.AddressVo;
import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 修改 StudentDomain.java 的 age 字段为 Integer 类型，
 * 修改 StudentVo.java 的 age 字段为 String 类型重新运行上述测试用例，
 * 双向映射，一切正常结论：Dozer 开箱即用的功能之一就是类型转换，
 * 多数类型我们不需要手动转换类型，完全交给 Dozer即可
 *
 *
 */
@Configuration
public class DozerConfig {

    @Bean
    public Mapper dozerMapper(){
        Mapper mapper = DozerBeanMapperBuilder.create()
                //指定 dozer mapping 的配置文件(放到 resources 类路径下即可)，可添加多个 xml 文件，用逗号隔开
                .withMappingFiles("dozerBeanMapping.xml")
                .withMappingBuilder(beanMappingBuilder())
                .build();
        return mapper;
    }

    @Bean
    public BeanMappingBuilder beanMappingBuilder() {
        return new BeanMappingBuilder() {


            // 个性化配置添加在此
            @Override
            protected void configure() {
//                // 默认隐式匹配
//                //测试所有properties，为不同名的 property 手动配置映射关系
//                mapping(StudentDomain.class, StudentVo.class)
//                        .fields("address", "addr");
//
//                //关闭隐式匹配
//                mapping(StudentDomain.class, StudentVo.class, TypeMappingOptions.wildcard(false))
//                        .fields("address", "addr");
//
//                //测试所有properties，为不同名的 property 手动配置映射关系，排除 mobile 字段
//                mapping(StudentDomain.class, StudentVo.class)
//                        .exclude("mobile")
//                        .fields("address", "addr");

                mapping(AddressDomain.class, AddressVo.class)
                        .fields("detail", "detailAddr");

//                //测试深度索引匹配
//                mapping(StudentDomain.class, StudentVo.class)
//                        .fields("courses[0].teacherName", "counsellor");
//
//                mapping(StudentDomain.class, StudentVo.class ,TypeMappingOptions.dateFormat("yyyy-MM-dd"))
//                        .fields("courses[0].teacherName", "counsellor");
//
//                //我们可以为 mapping 设置 mapId， 在转换的时候指定 mapId，mapId 可以设置在类级别，也可以设置在 field 级别，实现一次定义，多处使用，同时也可以设置转换方向从默认的双向变为单向（one way）：
//                mapping(StudentDomain.class, StudentVo.class, TypeMappingOptions.mapId("userFieldOneWay"))
//                        .fields("age", "age", FieldsMappingOptions.useMapId("addrAllProperties"), FieldsMappingOptions.oneWay());
            }

        };
    }




}
