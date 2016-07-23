/**
 * SynchTest.java  
 * Created on  3/2/15 下午3:03
 * modify on                user            modify content
 * 3/2/15 下午3:03        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.synch;

import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by micx  on 2015/02/03 下午3:03.
 */
public class SyncTest {

    public static synchronized void testSyncOnStaticMethod() {
        System.out.println("testSyncOnStaticMethod");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }
    }

    public static void testSyncOnClass() {
        synchronized (SyncTest.class) {
            System.out.println("testSyncOnClass");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
            }
        }
    }

    public synchronized void testSyncOnMethod() {
        System.out.println("testSyncOnMethod");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }
    }

    public void testSyncOnThis() {
        synchronized (this) {
            System.out.println("testSyncOnThis");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
            }
        }
    }

    public static void case1() {
        // case1
        // 先输出testSyncOnThis或者testSyncOnMethod
        // 然后停顿10秒，再输出另一个
        // 这个现象表明了

        // public synchronized void func() {
        // }

        // 等价于

        // public void func() {
        //     synchronized (this) {
        //     }
        // }
        final SyncTest t1 = new SyncTest();
        new Thread(new Runnable() {

            @Override
            public void run() {
                t1.testSyncOnThis();
            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                t1.testSyncOnMethod();
            }
        }).start();
    }

    public static void case2() {
        // case2
        // 先输出testSyncOnClass或者testSyncOnStaticMethod
        // 然后停顿10秒，再输出另一个
        // 这个现象表明了

        // public synchronized static void staticFunc() {
        // }

        // 等价于

        // public static void staticFunc() {
        //     synchronized (SyncTest.class) {
        //     }
        // }
        new Thread(new Runnable() {

            @Override
            public void run() {
                SyncTest.testSyncOnClass();
            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                SyncTest.testSyncOnStaticMethod();
            }
        }).start();
    }

    public static void main(String[] args) {
        case1();
        case2();
    }
}

