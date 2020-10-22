package com.zr.template.asyncTask;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 设置异步任务的线程池
 * @Author: 曾睿
 * @Date: 2020/10/22 14:00
 */
@Configuration
public class TaskConfiguration {
    @Bean("taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //核心线程数 线程池创建时候初始化的线程数，最小线程数
        executor.setCorePoolSize(10);
        //最大线程数 线程池最大的线程数，只有在缓冲队列满了之后，才会申请超过核心线程数的线程
        executor.setMaxPoolSize(20);
        //缓冲任务队列 用来缓冲执行任务的队列
        executor.setQueueCapacity(200);
        //允许线程的空闲时间 超过了核心线程之外的线程，在空闲时间到达之后，没活干的线程会被销毁
        executor.setKeepAliveSeconds(60);
        //线程池名的前缀 可以用于定位处理任务所在的线程池
        executor.setThreadNamePrefix("taskExecutor-");
        //线程池对任务的Reject策略 当线程池运行饱和，或者线程池处于shutdown临界状态时，用来拒绝一个任务的执行
        //AbortPolicy，用于被拒绝任务的处理程序，它将抛出RejectedExecutionException。
        //CallerRunsPolicy，用于被拒绝任务的处理程序，它直接在execute方法的调用线程中运行被拒绝的任务。
        //DiscardOldestPolicy，用于被拒绝任务的处理程序，它放弃最旧的未处理请求，然后重试execute。
        //DiscardPolicy，用于被拒绝任务的处理程序，默认情况下它将丢弃被拒绝的任务。
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        //该方法用来设置 线程池关闭 的时候 等待 所有任务都完成后，再继续 销毁 其他的 Bean，这样这些 异步任务 的 销毁 就会先于 数据库连接池对象 的销毁
        executor.setWaitForTasksToCompleteOnShutdown(true);
        //setAwaitTerminationSeconds(60): 该方法用来设置线程池中 任务的等待时间，如果超过这个时间还没有销毁就 强制销毁，以确保应用最后能够被关闭，而不是阻塞住。
        executor.setAwaitTerminationSeconds(60);

        return executor;
    }


}
