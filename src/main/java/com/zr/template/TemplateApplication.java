package com.zr.template;

import com.zr.template.config.FileStorageProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

// 开启异步处理
@EnableAsync
//开启定时任务
@EnableScheduling

@EnableConfigurationProperties({
        FileStorageProperties.class
})
@MapperScan(basePackages= {"com.zr.template.mapper"})
@SpringBootApplication
public class TemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemplateApplication.class, args);
    }

}
