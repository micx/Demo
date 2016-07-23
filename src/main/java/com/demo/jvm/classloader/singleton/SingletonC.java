/**
 * SingletonC.java
 * Created on  11/3/2016 8:49 AM
 * modify on                user            modify content
 * 11/3/2016 8:49 AM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.jvm.classloader.singleton;

/**
 * Created by micx  on 2016/03/11 8:49 AM.
 */
public class SingletonC {

    private static String str = "123";

    private SingletonC() {
        System.out.println(String.format("init Singleton, %s - %s", str,SingletonBuilder.instance));
    }

    public static SingletonC getInstance() {
        return SingletonBuilder.instance;
    }

    //在第一次被引用时被加载
    static class SingletonBuilder {
        private static SingletonC instance = new SingletonC();
    }

    public static void main(String args[]) {
        SingletonC instance = SingletonC.getInstance();
    }
}
