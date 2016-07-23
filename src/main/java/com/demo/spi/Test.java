/**
 * Test.java
 * Created on  17/2/2016 4:28 PM
 * modify on                user            modify content
 * 17/2/2016 4:28 PM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Created by micx  on 2016/02/17 4:28 PM.
 */
public class Test {
    public static void main(String[] args) {

        //设置线程上下文类加载器为null,则spi就找不到用户自定义的类了
        ClassLoader testLoader = Test.class.getClassLoader();
        ClassLoader testParentLoader = Test.class.getClassLoader().getParent();
//        System.out.println(String.format("curThreadClassLoader:\t%s \nparentClassLoader:\t%s",testLoader,testParentLoader));


//        Thread.currentThread().setContextClassLoader(testLoader);//AppLoader 找到可加载的类
//        Thread.currentThread().setContextClassLoader(testParentLoader);//ExtLoader 找不到可加载的类

        ServiceLoader<IOperation> serviceLoader = ServiceLoader.load(IOperation.class);
        System.out.println(serviceLoader.getClass().getClassLoader());
        Iterator<IOperation> operationIterator = serviceLoader.iterator();
        System.out.println(operationIterator.getClass().getClassLoader());
        while (operationIterator.hasNext()) {
            IOperation operation = operationIterator.next();
            System.out.println(operation.operation(6, 3));
        }
    }
}
