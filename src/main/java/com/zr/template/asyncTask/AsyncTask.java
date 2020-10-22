package com.zr.template.asyncTask;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

// 异步调用
@Component
public class AsyncTask extends AbstractTask {

    //@Async所修饰的函数不要定义为static类型，这样异步调用不会生效。
    @Override
    @Async
    public void doTaskOne() throws Exception {
        super.doTaskOne();
    }

    @Override
    @Async
    public void doTaskTwo() throws Exception {
        super.doTaskTwo();
    }

    @Override
    @Async
    public void doTaskThree() throws Exception {
        super.doTaskThree();
    }
}
