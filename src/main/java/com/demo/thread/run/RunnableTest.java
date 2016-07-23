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

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by micx  on 2016/06/01 11:11 PM.
 */
public class RunnableTest implements Runnable{
    private Future<String> future;
    public RunnableTest(Future<String> future) {
        this.future = future;
    }

    public void run() {
        String result = null;
        try {
            result = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("%s, result=%s",Thread.currentThread().getName(), result));
    }
}
