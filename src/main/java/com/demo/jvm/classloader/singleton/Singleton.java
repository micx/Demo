/**
 * Singleton.java
 * Created on  11/3/2016 8:48 AM
 * modify on                user            modify content
 * 11/3/2016 8:48 AM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.jvm.classloader.singleton;

/**
 * Created by micx  on 2016/03/11 8:48 AM.
 */
public class Singleton {
    private static String str = "123";
    private static Singleton s = new Singleton();


    public Singleton() {
        System.out.println(String.format("init Singleton, %s - %s", s, str));
    }

    public static Singleton getInstance(){
        return s;
    }

    public static void main(String[] args) {
        Singleton.getInstance();
    }

}
