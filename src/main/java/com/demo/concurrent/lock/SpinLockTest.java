/**
 * SpinLockTest.java  
 * Created on  3/6/15 9:18 AM
 * modify on                user            modify content
 * 3/6/15 9:18 AM        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.concurrent.lock;

import com.demo.callback.thread.ThreadPool;

/**
 * Created by micx  on 2015/06/03 9:18 AM.
 */
public class SpinLockTest implements Runnable {

    SpinLock lock = new SpinLock();
    private int x;
    @Override
    public void run() {
        while (true) {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "\tvalue=" + x);
            x++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        SpinLockTest spinLockTest = new SpinLockTest();
        ThreadPool.add(spinLockTest);
        ThreadPool.add(spinLockTest);
        ThreadPool.add(spinLockTest);
        ThreadPool.add(spinLockTest);
    }
}
