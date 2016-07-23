/**
 * ThreadPool.java  
 * Created on  13/3/15 下午1:41
 * modify on                user            modify content
 * 13/3/15 下午1:41        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by micx  on 2015/03/13 下午1:41.
 */
public class ThreadPoolImpl {
    private static final int POOL_SIZE = 5;
    private static ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);

    public static void submit(Runnable runnable){
        Future<?> future = executor.submit(runnable);
    }

    public static void shutDown() {
        executor.shutdown();
    }
}
