/**
 * DeamonTest.java
 * Created on  6/6/2016 7:55 AM
 * modify on                user            modify content
 * 6/6/2016 7:55 AM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.thread.deamon;

import java.util.Date;
import java.util.Scanner;

/**
 * Created by micx  on 2016/06/06 7:55 AM.
 */
public class DeamonTest implements Runnable {
    private boolean isStop;
    private Thread thread;

    public void start(){
        thread = new Thread(this, "deamon thread");
        thread.setDaemon(true);
        thread.start();
    }


    public void run() {
        while (!isStop){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(new Date());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DeamonTest test = new DeamonTest();
        test.start();

        System.out.println("isDaemon = " + test.isDaemon());
        Scanner scanner = new Scanner(System.in);
        // 接受输入，使程序在此停顿，一旦接受到用户输入,main线程结束，JVM退出!
        scanner.next();
        //AddShutdownHook方法增加JVM停止时要做处理事件：
        //当JVM退出时，打印JVM Exit语句.
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                // TODO Auto-generated method stub
                System.out.println("JVM Exit!");
            }
        });
    }

    private boolean isDaemon() {
        return thread.isDaemon();
    }


}
