/**
 * Singletom.java
 * Created on  12/1/2016 9:49 AM
 * modify on                user            modify content
 * 12/1/2016 9:49 AM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.singleton;

/**
 * Created by micx  on 2016/01/12 9:49 AM.
 */
public class Singleton {
    static{
        System.out.println("load Singleton");
    }
    Singleton() {
        System.out.println("init Singleton");
    }

    public static Singleton getInstance() {
        return SingletonBuilder.instance;
    }

    //在第一次被引用时被加载
    static class SingletonBuilder {
        private static Singleton instance = new Singleton();
        static{
            System.out.println("load SingletonBuilder"+ instance);
        }
    }

    public class InnerClass{

    }

    public static void main(String args[]) {
        Singleton instance = Singleton.getInstance();
//        Singleton
        //        Singleton instance2 = Singleton.getInstance();
//        System.out.println(instance == instance2);
    }
}
