/**
 * ThreadPool.java  
 * Created on  3/3/15 上午8:47
 * modify on                user            modify content
 * 3/3/15 上午8:47        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.callback.thread;

import java.util.concurrent.ExecutorService;

/**
 * Created by micx  on 2015/03/03 上午8:47.
 */
public class ThreadPool {
    private static ExecutorService executor = java.util.concurrent.Executors.newFixedThreadPool(10);

    public static void add(Runnable task){
        executor.submit(task);
    }
}
