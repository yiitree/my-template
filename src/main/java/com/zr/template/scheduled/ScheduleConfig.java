package com.zr.template.scheduled;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
// 开启定时任务，或者记载启动类上也可以，二选一即可
//@EnableScheduling
public class ScheduleConfig implements SchedulingConfigurer {

    //解决定时任务单线程运行的问题
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(scheduledTaskExecutor());
    }

    @Bean
    public Executor scheduledTaskExecutor() {
        //指定线程池大小
        return Executors.newScheduledThreadPool(3);
    }
}
