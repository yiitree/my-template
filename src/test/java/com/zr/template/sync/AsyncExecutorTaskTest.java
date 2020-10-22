package com.zr.template.sync;

import com.zr.template.asyncTask.AsyncExecutorTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static java.lang.Thread.sleep;

/**
 * @Author: 曾睿
 * @Date: 2020/10/22 14:03
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AsyncExecutorTaskTest {

    @Autowired
    private AsyncExecutorTask task;

    @Test
    public void testAsyncExecutorTask() throws Exception {
        task.doTaskOneCallback();
        task.doTaskTwoCallback();
        task.doTaskThreeCallback();

        sleep(30 * 1000L);
    }


}
