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
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by micx  on 2016/06/01 11:11 PM.
 */
public class FutureTest implements Future<String>{
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return false;
    }

    public String get() throws InterruptedException, ExecutionException {
        return null;
    }

    public String get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }
}
