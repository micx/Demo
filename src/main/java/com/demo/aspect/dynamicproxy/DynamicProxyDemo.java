/**
 * TestDProxy.java
 * Created on  18/1/2016 9:51 AM
 * modify on                user            modify content
 * 18/1/2016 9:51 AM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.aspect.dynamicproxy;

import com.demo.aspect.dynamicproxy.iface.IBusiness;
import com.demo.aspect.dynamicproxy.iface.IBusiness2;

import java.lang.reflect.Proxy;

/**
 * Created by micx  on 2016/01/18 9:51 AM.
 */
public class DynamicProxyDemo {
    public static void main(String[] args) {
        //需要代理的接口，被代理类实现的多个接口都必须在这里定义
        Class[] proxyInterface = new Class[] { IBusiness.class, IBusiness2.class };
        //构建AOP的Advice，这里需要传入业务类的实例
        LogInvocationHandler handler = new LogInvocationHandler(new Business());
        //生成代理类的字节码加载器
        ClassLoader classLoader = DynamicProxyDemo.class.getClassLoader();
        //织入器，织入代码并生成代理类
        IBusiness2 proxyBusiness = (IBusiness2) Proxy.newProxyInstance(classLoader, proxyInterface, handler);
        //使用代理类的实例来调用方法。
        proxyBusiness.doSomeThing2();
        ((IBusiness) proxyBusiness).doSomeThing();
    }
}
