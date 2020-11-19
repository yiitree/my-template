package com.zr.template.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ScheduledJobs {

    //表示方法执行完成后5秒再开始执行 是当任务执行完毕后一段时间再次执行。（开始--->结束(隔一分钟)开始----->结束）。上一次执行任务未完成，下一次任务不会开始。
    @Scheduled(fixedDelay=5000)
    public void fixedDelayJob() throws InterruptedException{
        System.out.println("Scheduled 开始:" + new Date());
        Thread.sleep(10 * 1000);
        System.out.println("Scheduled 结束:" + new Date());
    }

    //表示每隔3秒 如果间隔时间小于任务执行时间，上一次任务执行完成下一次任务就立即执行。如果间隔时间大于任务执行时间，就按照每隔X时间运行一次
    @Scheduled(fixedRate=3000)
    public void fixedRateJob()throws InterruptedException{
        System.out.println("===========Scheduled 开始:" + new Date());
        Thread.sleep(5 * 1000);
        System.out.println("===========Scheduled 结束:" + new Date());
    }

    //自定义方式 表示每隔10秒执行一次
    @Scheduled(cron="0/10 * * * * ? ")
    public void cronJob(){
        System.out.println("Scheduled=========================== ...>>cron...." + new Date());
    }
}
