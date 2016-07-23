/**
 * BookFacadeCglib.java  
 * Created on  16/1/15 上午9:27
 * modify on                user            modify content
 * 16/1/15 上午9:27        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.future.proxy;

import com.demo.future.task.TestCglibTask;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by micx  on 2015/01/16 上午9:27.
 */
public class CommonCglib<T> implements MethodInterceptor {
    private ExecutorService executor = Executors.newFixedThreadPool(10);

    /**
     * 创建代理对象
     * @param target
     * @return
     */
    public T getInstance(Object target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return (T)enhancer.create();
    }

    // 回调方法
    public Object intercept(Object obj, Method method, Object[] args,
                            MethodProxy proxy) throws Throwable {
        TestCglibTask task = new TestCglibTask(obj, proxy, args);
        Future future = executor.submit(task);
        ServiceFutureFactory.setFuture(future);
        return null;
    }
}
