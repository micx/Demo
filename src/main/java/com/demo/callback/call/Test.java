/**
 * Test.java  
 * Created on  4/1/15 上午9:44
 * modify on                user            modify content
 * 4/1/15 上午9:44        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.callback.call;

import java.util.concurrent.*;

/**
 * Created by micx  on 2015/01/04 上午9:44.
 */
public class Test {
    public static void main(String[] args) {
        base();
        threadCallBack();
    }

    private static void threadCallBack() {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        long startTime = System.currentTimeMillis();
        FutureTask<String>[] futureTask = new FutureTask[10];
        for (int i=0; i<10;++i) {
            futureTask[i] = new FutureTask<String>(new Client(i));
            executor.submit(futureTask[i]);
        }
        //other operations...
        for (int i = 0; i < 10; i++) {
            try {
                String result = futureTask[i].get(1000, TimeUnit.MILLISECONDS); //取得结果，同时设置超时执行时间为5秒。同样可以用future.get()，不设置执行超时时间取得结果
                System.out.println(String.format("cost: %d ms", (System.currentTimeMillis() - startTime)));
                System.out.println(result);
            } catch (InterruptedException e) {
                futureTask[i].cancel(true);
                System.out.println(e);
            } catch (ExecutionException e) {
                futureTask[i].cancel(true);
                System.out.println(e);
            } catch (TimeoutException e) {
                futureTask[i].cancel(true);
                System.out.println(e);
            } finally {
                executor.shutdown();
            }
        }
    }

    public static void base() {
        Caller caller = new Caller();
        caller.setCallFunc(new Client());
        caller.call();
    }
}
