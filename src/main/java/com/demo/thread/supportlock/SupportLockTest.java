/**
 * SupportLockTest.java
 * Created on  6/6/2016 11:47 AM
 * modify on                user            modify content
 * 6/6/2016 11:47 AM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.thread.supportlock;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by micx  on 2016/06/06 11:47 AM.
 */
public class SupportLockTest {

    private static  Thread mainThread ;
    public static void main(String[] args) {


        testInterrupt();

//        Thread thread = Thread.currentThread();
//        LockSupport.unpark(thread);//释放许可
//        LockSupport.unpark(thread);//释放许可
//        LockSupport.park();// 获取许可
//        LockSupport.park();// 获取许可
//        System.out.println("b");


//        Thread thread = new Thread(new InnerTask());
//        thread.start();
//        mainThread = Thread.currentThread();
//        System.out.println("park mainThread");
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(LockSupport.getBlocker(thread));
//        LockSupport.unpark(thread);
//
//        Scanner scanner = new Scanner(System.in);
//        // 接受输入，使程序在此停顿，一旦接受到用户输入,main线程结束，JVM退出!
//        scanner.next();
    }

    private static void testInterrupt() {

        Thread t = new Thread(new Runnable()
        {
            private int count = 0;

            @Override
            public void run()
            {
                long start = System.currentTimeMillis();
                long end = 0;

                while ((end - start) <= 1000)
                {
                    count++;
                    end = System.currentTimeMillis();
                }

                System.out.println("after 1 second.count=" + count);

                //等待或许许可
                LockSupport.park();
//                LockSupport.park();
                System.out.println("thread over." + Thread.currentThread().isInterrupted());
            }
        });

        t.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 中断线程
//        t.interrupt();

        LockSupport.unpark(t);
        LockSupport.unpark(t);

        System.out.println("main over");
    }

    private static class InnerTask implements Runnable{

        public void run() {
            int i=0;
            while (true) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("InnerTask\t"+i);
                i++;
                LockSupport.park(Thread.currentThread());
            }

        }
    }
}