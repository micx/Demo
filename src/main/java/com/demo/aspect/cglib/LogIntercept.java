/**
 * LogIntercept.java
 * Created on  18/1/2016 10:12 AM
 * modify on                user            modify content
 * 18/1/2016 10:12 AM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.aspect.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by micx  on 2016/01/18 10:12 AM.
 */
public class LogIntercept implements MethodInterceptor {

    public Object intercept(Object target, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        //执行原有逻辑，注意这里是invokeSuper
        Object rev = proxy.invokeSuper(target, args);
        //执行织入的日志
        if (method.getName().equals("doSomeThing2")) {
            System.out.println("记录日志");
        }
        return rev;
    }
}

