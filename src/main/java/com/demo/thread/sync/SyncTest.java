/**
 * SyncTest.java
 * Created on  31/1/2016 7:11 PM
 * modify on                user            modify content
 * 31/1/2016 7:11 PM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.thread.sync;

import com.demo.thread.ThreadPoolImpl;

/**
 * Created by micx  on 2016/01/31 7:11 PM.
 */
public class SyncTest implements Runnable{
    private static volatile int x = 0;
    private static volatile Object obj = new Object();

    private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
    private ThreadLocal<String> threadLocalStr = new ThreadLocal<String>();
    public static void main(String[] args) {
        SyncTest syncTest = new SyncTest();
        ThreadPoolImpl.submit(syncTest);
        ThreadPoolImpl.submit(syncTest);
        System.out.println("123");

    }
    public void run() {
//        threadLocalTest();
        while (true) {
            synchronized (this) {

                x++;
                System.out.println(x);
            }


//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            try {
                this.wait();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    private void threadLocalTest() {
        threadLocal.set((int) Thread.currentThread().getId());
        threadLocalStr.set(Thread.currentThread().getName());
        Integer integer = threadLocal.get();
        String name = threadLocalStr.get();
        System.out.println(integer);
        System.out.println(name);

    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
