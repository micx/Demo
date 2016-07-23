/**
 * ThreadPool.java  
 * Created on  13/4/15 9:30 AM
 * modify on                user            modify content
 * 13/4/15 9:30 AM        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by micx  on 2015/04/13 9:30 AM.
 */
public interface ThreadPool {
    public void execute(Runnable run);

    public <T> Future<T> submit(Callable<T> call);

    public Future<?> submit(Runnable run);

    public ThreadPoolExecutor getExecutor();
}
