/**
 * ClassLoaderTest2.java
 * Created on  10/3/2016 10:34 PM
 * modify on                user            modify content
 * 10/3/2016 10:34 PM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.jvm.classloader;

import com.demo.jvm.classloader.entity.B;

/**
 * Created by micx  on 2016/03/10 10:34 PM.
 */
public class ClassLoaderTest2 implements Runnable{
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = ClassLoaderTest2.class.getClassLoader();
        System.out.println(loader);
//        使用ClassLoader.loadClass()来加载类，不会执行初始化块
        Class<B> aClass = (Class<B>) loader.loadClass("com.demo.jvm.classloader.entity.B");
//
//        ThreadPoolImpl.submit(new ClassLoaderTest2());
//        ThreadPoolImpl.submit(new ClassLoaderTest2());


        //使用Class.forName()来加载类，默认会执行初始化块
//        Class.forName("com.demo.jvm.classloader.entity.Test2");
        //使用Class.forName()来加载类，并指定ClassLoader，初始化时不执行静态块
//        Class<?> aClass = Class.forName("com.demo.jvm.classloader.entity.B", false, loader);

    }

    public void run() {
        B instance = B.getInstance();
        System.out.println(instance);
    }
}
