/**
 * LogInvocationHandler.java
 * Created on  18/1/2016 9:47 AM
 * modify on                user            modify content
 * 18/1/2016 9:47 AM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.aspect.dynamicproxy;

/**
 * Created by micx  on 2016/01/18 9:47 AM.
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 打印日志的切面
 */
public class LogInvocationHandler implements InvocationHandler {

    private Object target; //目标对象

    LogInvocationHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //执行原有逻辑
        Object rev = method.invoke(target, args);
        //执行织入的日志，你可以控制哪些方法执行切入逻辑
        if (method.getName().equals("doSomeThing2")) {
            System.out.println("记录日志");
        }
        return rev;
    }
}

//接口IBusiness和IBusiness2定义省略。
