/**
 * B.java
 * Created on  9/3/2016 5:02 PM
 * modify on                user            modify content
 * 9/3/2016 5:02 PM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.jvm.classloader.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created by micx  on 2016/03/09 5:02 PM.
 */
public class B extends A {
    private static B b ;
//    private  static B b = new B();
    private int x ;
    private int y ;
    private int z ;

    private int xxx(){
        return 2;
    }

    public B() {
        System.out.println(Thread.currentThread().getId());
        if (x == 0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("init B");
        x = 1;
        y = 2;
        z = 3;
    }

//    public static B getInstance(){
//        return b;
//    }

    public static B getInstance(){
        System.out.println("a");
        if (b == null){
            synchronized (B.class){
                if (b == null){
                    return  b = new B();
                }
            }
        }
        return b;
    }

    public int plusB(int x, int y){
        printInfo();
        return plus(x, y);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);

    }
}
