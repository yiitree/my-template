package com.zr.template.quartz;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 定时任务配置类
 */
@Configuration
public class QuartzSimpleConfig {

    /**
     * 包含多个构造函数，最常用的是JobDetail(String name, String group, Class jobClass)Jobclass是实现作业接口的类，name是调度程序中任务的名称，group是调度程序中任务的组名。默认组名称为Scheduler.DEFAULT_GROUP。
     * @return
     */
    //指定具体的定时任务类
    @Bean
    public JobDetail uploadTaskDetail() {
        return JobBuilder.newJob(QuartzSimpleTask.class)
                .withIdentity("QuartzSimpleTask")
                .storeDurably().build();
    }

    //Trigger：描述触发作业执行的时间规则的类。
    //SimpleTrigger：一次或固定间隔时间段的触发规则。
    //CronTrigger：通过cron表达式描述更复杂的触发规则。
    //Calendar：Quartz 提供的Calendar类。触发器可以与多个Calendar关联以排除特殊日期。
    //Scheduler：代表独立于Quartz 的运行容器。在Scheduler 中注册了Trigger和JobDetail。它们在调度程序中具有自己的名称（名称）和组名称（Group）。触发器和JobDetail名称和组名称的组合必须唯一，但是触发器名称和组名称的组合可以与JobDetail相同。一个Job可以绑定到多个触发器，也可以不绑定。

    //SimpleTrigger and CronTrigger
    //SimpleTrigger可以在指定的时间段内执行一个Job任务，也可以在一个时间段内多次执行。
    //CronTrigger功能非常强大，它基于Calendar进行作业调度，并且可以比simpletrigger更精确地指定间隔，因此crotrigger比simpletrigger更常用。Crotrigger基于cron表达式。
    @Bean
    public Trigger uploadTaskTrigger() {
        //这里设定触发执行的方式
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/5 * * * * ?");
        // 返回任务触发器
        return TriggerBuilder.newTrigger().forJob(uploadTaskDetail())
                .withIdentity("QuartzSimpleTask")
                .withSchedule(scheduleBuilder)
                .build();
    }
}
