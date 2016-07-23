/**
 * TaskTest.java
 * Created on  26/5/2016 10:08 AM
 * modify on                user            modify content
 * 26/5/2016 10:08 AM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by micx  on 2016/05/26 10:08 AM.
 */
public class TaskTest {
    static ScheduledThreadPoolExecutor stpe = null;
    static int index;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {


//        schedule();
        threadPoool();


    }

    private static void threadPoool() {
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<Runnable>(3);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3, 10, TimeUnit.SECONDS, linkedBlockingQueue);
//        try {
////            System.out.println(linkedBlockingQueue.put(new MyTask()));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        });
        System.out.println(linkedBlockingQueue.add(new MyTask()));
        System.out.println(linkedBlockingQueue.offer(new MyTask()));
        linkedBlockingQueue.poll();
        System.out.println(linkedBlockingQueue.offer(new MyTask()));
        System.out.println(linkedBlockingQueue.offer(new MyTask()));
        System.out.println(linkedBlockingQueue.offer(new MyTask()));
        System.out.println(linkedBlockingQueue.offer(new MyTask()));
        System.out.println(linkedBlockingQueue.offer(new MyTask()));
        System.out.println(linkedBlockingQueue.offer(new MyTask()));


        linkedBlockingQueue.poll();
//        linkedBlockingQueue.take();


    }

    private static void schedule() {
        stpe = new ScheduledThreadPoolExecutor(2);
        MyTask task = new MyTask();
        stpe.schedule(task, 2, TimeUnit.SECONDS);
        stpe.schedule(task, 4, TimeUnit.SECONDS);
        stpe.schedule(task, 15, TimeUnit.SECONDS);
        stpe.schedule(task, 16, TimeUnit.SECONDS);
        stpe.schedule(task, 17, TimeUnit.SECONDS);
        stpe.schedule(task, 7, TimeUnit.SECONDS);
        stpe.schedule(task, 7, TimeUnit.SECONDS);
        stpe.schedule(task, 7, TimeUnit.SECONDS);
        stpe.schedule(task, 7, TimeUnit.SECONDS);
        stpe.schedule(task, 7, TimeUnit.SECONDS);
        stpe.schedule(task, 7, TimeUnit.SECONDS);
        stpe.schedule(task, 7, TimeUnit.SECONDS);
        stpe.schedule(task, 7, TimeUnit.SECONDS);
        while (true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private static String getTimes() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
        Date date = new Date();
        date.setTime(System.currentTimeMillis());
        return format.format(date);
    }

    private static class MyTask implements Runnable {
        public void run() {
            index++;
            System.out.println("2= " + getTimes()+" "  +index);
            if(index >=10){
                stpe.shutdown();
                if(stpe.isShutdown()){
                    System.out.println("停止了？？？？");
                }
            }
        }
    }
}
