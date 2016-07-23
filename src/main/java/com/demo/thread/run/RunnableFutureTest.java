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

import clover.retrotranslator.edu.emory.mathcs.backport.java.util.concurrent.ExecutionException;
import clover.retrotranslator.edu.emory.mathcs.backport.java.util.concurrent.RunnableFuture;
import clover.retrotranslator.edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import clover.retrotranslator.edu.emory.mathcs.backport.java.util.concurrent.TimeoutException;

/**
 * Created by micx  on 2016/06/01 11:11 PM.
 */
public class RunnableFutureTest implements RunnableFuture{
    public void run() {

    }

    public boolean cancel(boolean b) {
        return false;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return false;
    }

    public Object get() throws InterruptedException, ExecutionException {
        return null;
    }

    public Object get(long l, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }
}
