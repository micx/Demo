/**
 * DefaultThreadPoolImpl.java  
 * Created on  13/4/15 9:31 AM
 * modify on                user            modify content
 * 13/4/15 9:31 AM        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.thread.impl;

import com.demo.thread.ThreadPool;
import io.netty.util.concurrent.DefaultThreadFactory;

import java.util.concurrent.*;

/**
 * Created by micx  on 2015/04/13 9:31 AM.
 */
public class DefaultThreadPoolImpl implements ThreadPool {
    private String name;

    private ThreadPoolExecutor executor;
    private DefaultThreadFactory factory;

    public DefaultThreadPoolImpl(String poolName) {
        this.name = poolName;
        this.executor = (ThreadPoolExecutor) Executors.newCachedThreadPool(new DefaultThreadFactory(poolName));
    }

    public DefaultThreadPoolImpl(String poolName, int corePoolSize, int maximumPoolSize) {

        this(poolName, corePoolSize, maximumPoolSize, new SynchronousQueue<Runnable>());
    }

    public DefaultThreadPoolImpl(String poolName, int corePoolSize, int maximumPoolSize, BlockingQueue<Runnable> workQueue) {
        this(poolName, corePoolSize, maximumPoolSize, workQueue, new ThreadPoolExecutor.AbortPolicy());
    }

    public DefaultThreadPoolImpl(String poolName, int corePoolSize, int maximumPoolSize, BlockingQueue<Runnable> workQueue,
                             RejectedExecutionHandler handler) {
        this.name = poolName;
        this.factory = new DefaultThreadFactory(this.name);
        this.executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, 60, TimeUnit.SECONDS, workQueue,
                this.factory, handler);
    }

    public void execute(Runnable run) {
        this.executor.execute(run);
    }

    public <T> Future<T> submit(Callable<T> call) {
        return this.executor.submit(call);
    }

    public Future<?> submit(Runnable run) {
        return this.executor.submit(run);
    }

    public ThreadPoolExecutor getExecutor() {
        return this.executor;
    }
}
