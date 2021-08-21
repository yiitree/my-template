package com.zr.template.httpClient;

import cn.hutool.http.HttpUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Demo {


    @Test
    public void test(){
        long l = System.currentTimeMillis();
        for (int i = 0; i < 200; i++) {
            String result1 = HttpUtil.get("https://www.baidu.com");
            System.out.println(result1.substring(1, 10) +";"+ i);
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l); // 18328
    }

    @Test
    public void test2() throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(10); // 2 10350 3 7687 4 6551  5 5837  10 5161
        long l = System.currentTimeMillis();
        List<Future<String>> list = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
        Future<String> submit = pool.submit(() ->{
                System.out.println(Thread.currentThread().getName());
                return HttpUtil.get("https://www.baidu.com");
            });

            list.add(submit);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).get().substring(1, 10) +";"+ i);
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l); // 4104
        Thread.sleep(10000);
    }

    @Test
    public void test3() {
        ExecutorService pool = Executors.newFixedThreadPool(1); // 2 10350 3 7687 4 6551  5 5837
        Future<D> submit = pool.submit(() -> {
            int i = 1 / 0;
            return new D(1, "10");
        });
        D d = null;
        try {
            d = submit.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("1");
            throw new RuntimeException("4456");
        } catch (ExecutionException e) {
            System.out.println("2");
            e.printStackTrace();
        }
        Integer id = d.getId();
        System.out.println(id);
    }
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class D{
    private Integer id;
    private String name;
}
