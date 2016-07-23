/**
 * Test.java
 * Created on  15/12/2015 10:57 AM
 * modify on                user            modify content
 * 15/12/2015 10:57 AM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.thread.test;

import java.util.concurrent.*;

/**
 * Created by micx  on 2015/12/15 10:57 AM.
 */
public class Test implements Runnable{

    private ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5,
                                                                     0L,TimeUnit.MILLISECONDS,
                                                                     new LinkedBlockingQueue<Runnable>(1));

    private ThreadLocal<Integer> tli = new ThreadLocal<Integer>();
    private ThreadLocal<Long> tll = new ThreadLocal<Long>();
    private ThreadLocal<String> tls = new ThreadLocal<String>();

    public void start(){
        tli.set(1);
        tll.set(1L);
        tls.set("1");

        tli.get();
        tll.get();
        tls.get();



        ExecutorService pool1 = Executors.newSingleThreadExecutor();
        ExecutorService pool2 = Executors.newFixedThreadPool(1);
        ExecutorService pool3 = Executors.newCachedThreadPool();
        ScheduledExecutorService pool4 = Executors.newScheduledThreadPool(10);



        executor.submit(this);
        executor.submit(this);
        executor.submit(this);
        executor.submit(this);
        executor.submit(this);
        executor.submit(this);
        executor.submit(this);
    }

    public void run() {
        while (true){
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int x = 1;
            int y = 0;
            int i = x / y;
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.start();
    }
}
