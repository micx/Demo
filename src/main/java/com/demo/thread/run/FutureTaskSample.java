/**
 * a.java
 * Created on  1/6/2016 11:41 PM
 * modify on                user            modify content
 * 1/6/2016 11:41 PM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.thread.run;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by micx  on 2016/06/01 11:41 PM.
 */
public class FutureTaskSample {
    static FutureTask<String> future = new FutureTask(new Callable<String>(){
        public String call(){
            return getPageContent();
        }
    });
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        

        //Start a thread to let this thread to do the time exhausting thing
        new Thread(future).start();

        //Main thread can do own required thing first
        System.out.println(doOwnThing());

        //At the needed time, main thread can get the result
        System.out.println(future.get());
    }

    public static String doOwnThing(){
        return "Do Own Thing";
    }
    public static String getPageContent(){
        return "Callable method...";
    }
}