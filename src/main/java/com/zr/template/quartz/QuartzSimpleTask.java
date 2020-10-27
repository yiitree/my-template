package com.zr.template.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * 自定义一个定时任务
 * 然后需要再config中配置(配置触发条件)
 */
public class QuartzSimpleTask extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("quartz简单的定时任务执行时间："+new Date());
    }

}
