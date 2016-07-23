/**
 * ThreadTest.java
 * Created on  1/3/2016 9:48 PM
 * modify on                user            modify content
 * 1/3/2016 9:48 PM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.thread.sync;

/**
 * Created by micx  on 2016/03/01 9:48 PM.
 */
public class ThreadTest {

    public static void main(String[] args) {

        new Thread(new ThreadDemo()).start();

    }
}

class ThreadDemo implements Runnable {
    private int i = 0;
    private static Object obj = new Object();

    public  void run() {

            try {
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }


        System.out.println(Thread.currentThread().getName() + ":" + i);

    }
}
