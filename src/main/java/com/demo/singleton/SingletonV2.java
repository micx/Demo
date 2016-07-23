/**
 * SingletonV2.java
 * Created on  7/6/2016 5:03 PM
 * modify on                user            modify content
 * 7/6/2016 5:03 PM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.singleton;

/**
 * Created by micx  on 2016/06/07 5:03 PM.
 */
public class SingletonV2 {
    public static void main(String[] args) {
        Singleton singleton = new Singleton();

        Singleton.SingletonBuilder singletonBuilder = new Singleton.SingletonBuilder();
        Singleton.InnerClass innerClass = singleton.new InnerClass();
        new Singleton();

    }
}
