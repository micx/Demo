/**
 * BookFacadeProxy.java  
 * Created on  16/1/15 上午9:17
 * modify on                user            modify content
 * 16/1/15 上午9:17        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by micx  on 2015/01/16 上午9:17.
 */
public class BookFacadeProxy implements InvocationHandler {
    private Object target;


    public void init(String iface) throws Exception {
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class<?> clazz = classLoader.loadClass(iface.trim());
        bind(clazz.newInstance());
    }
    /**
     * 绑定委托对象并返回一个代理类
     * @param target
     * @return
     */
    public Object bind(Object target) {
        this.target = target;
        //取得代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(), this);   //要绑定接口(这是一个缺陷，cglib弥补了这一缺陷)
    }

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        String str = "hello ssss....";
        Object result= str;
        System.out.println("事物开始");
        //执行方法
        method.invoke(target, args);
        System.out.println("事物结束");
        return result;
    }

}
