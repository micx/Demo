/**
 * ThreadPoolTest.java  
 * Created on  12/4/15 5:14 PM
 * modify on                user            modify content
 * 12/4/15 5:14 PM        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.thread;

import com.demo.thread.impl.DefaultThreadPoolImpl;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by micx  on 2015/04/12 5:14 PM.
 */
public class ThreadPoolTest implements Runnable{

    private static final AtomicLong along = new AtomicLong();

    public static void main(String[] args) {
        ThreadPool threadPool = new DefaultThreadPoolImpl("micx",2,5);
        for (int i = 0; i < 2; i++) {
            threadPool.submit(new ThreadPoolTest());
        }
//        ThreadPool.shutDown();
    }


    public void run() {
        int count = 0;
        for (int i = 0; i < Math.random()*100000 +2000; i++) {
            ++count;
        }
        try {
            Thread.sleep(count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long start = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "count: " + along.incrementAndGet() + "\t cost: " + (System.currentTimeMillis() - start));
    }

    public static long getMemory() {
        return Runtime.getRuntime().freeMemory();
    }
}
