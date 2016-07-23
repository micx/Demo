/**
 * RunnableTest.java
 * Created on  1/6/2016 11:11 PM
 * modify on                user            modify content
 * 1/6/2016 11:11 PM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.thread.run;

import java.util.Date;
import java.util.concurrent.*;

/**
 * Created by micx  on 2016/06/01 11:11 PM.
 */
public class CallableTest implements Callable<String>{
    public String call() throws Exception {
        Thread.sleep(11111200);
        Date date = new Date();
        return "callable="+date;
    }

    public static void main(String[] args) {
        ThreadPoolExecutor exec = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        Future<String> callFuture = exec.submit(new CallableTest());
        Future<?> runFuture = exec.submit(new RunTask());

        try {
            System.out.println("start get...");
            runFuture.get();
            System.out.println("end get...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    static class RunTask implements Runnable{

        public void run() {
            System.out.println("RunTask start sleep...");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("RunTask end sleep...");

        }
    }
}
