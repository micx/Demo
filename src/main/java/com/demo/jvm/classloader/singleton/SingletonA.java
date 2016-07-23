/**
 * SingletonA.java
 * Created on  11/3/2016 8:31 AM
 * modify on                user            modify content
 * 11/3/2016 8:31 AM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.jvm.classloader.singleton;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created by micx  on 2016/03/11 8:31 AM.
 */
public class SingletonA {
    private static SingletonB b = new SingletonB();
    public static int x = 1;
    public int y = 2;

    public SingletonA() {
        System.out.println(String.format("init SingletonA, b = %s, x = %s, y = %s", b, x, y));
    }

    public static SingletonB getInstance(){
        return b;
    }

    public static void main(String[] args) {
        SingletonB a = SingletonA.getInstance();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);

    }
}
