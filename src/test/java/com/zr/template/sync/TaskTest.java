package com.zr.template.sync;

import com.zr.template.asyncTask.T01SyncTask;
import com.zr.template.asyncTask.T02AsyncTask;
import com.zr.template.asyncTask.T03AsyncCallBackTask;
import com.zr.template.asyncTask.T04AsyncExecutorTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;

import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.sleep;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskTest {

    // 01、正常同步调用
    @Autowired
    private T01SyncTask task;
    // 02、异步调用
    @Autowired
    private T02AsyncTask asyncTask;

    //------------------------------------------------------------------------
    // 03、异步调用---有返回
    @Autowired
    private T03AsyncCallBackTask asyncCallBackTask;
    // 04、使用线程池调用
    @Autowired
    private T04AsyncExecutorTask tasks;

    //------------------------------------------------------------------------

    @Test
    public void testSyncTasks() throws Exception {
        task.doTaskOne();
        task.doTaskTwo();
        task.doTaskThree();
    }

    @Test
    public void testAsyncTasks() throws Exception {
        asyncTask.doTaskOne();
        asyncTask.doTaskTwo();
        sleep(30 * 100L);
        asyncTask.doTaskThree();
    }

    //------------------------------------------------------------------------

    @Test
    public void testAsyncCallbackTask() throws Exception {
        long start = currentTimeMillis();
        Future<String> task1 = asyncCallBackTask.doTaskOneCallback();
        Future<String> task2 = asyncCallBackTask.doTaskTwoCallback();
        Future<String> task3 = asyncCallBackTask.doTaskThreeCallback();

        // 三个任务都调用完成，退出循环等待
//        while (!task1.isDone() || !task2.isDone() || !task3.isDone()) {
//            sleep(1000);
//        }
        final String s1 = task1.get();
        final String s2 = task2.get();
        final String s3 = task3.get();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);


        long end = currentTimeMillis();
        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }

    @Test
    public void testAsyncExecutorTask() throws Exception {
        tasks.doTaskOneCallback();
        tasks.doTaskTwoCallback();
        tasks.doTaskThreeCallback();
    }

}
