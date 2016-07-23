/**
 * A.java
 * Created on  9/3/2016 5:01 PM
 * modify on                user            modify content
 * 9/3/2016 5:01 PM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.jvm.classloader.entity;

/**
 * Created by micx  on 2016/03/09 5:01 PM.
 */
public class A implements IA{
    private int z;

    private int xxx(){
        return 1;
    }

    public int plus(int x, int y) {
        printInfo();
        return x + y;
    }
    public void printInfo(){
        System.out.println(String.format("%s - %s",this.getClass().getName(),
                this.getClass().getClassLoader()));
    }
}
