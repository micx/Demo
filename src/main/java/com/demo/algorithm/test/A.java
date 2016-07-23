/**
 * A.java  
 * Created on  14/11/14 下午4:20
 * modify on                user            modify content
 * 14/11/14 下午4:20        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.algorithm.test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by micx  on 2014/11/14 下午4:20.
 */
public class A {
    private static B b = new B();

    public A(){
        System.out.println(b == null);
        System.out.println(b.i);
    }

    public static void main(String[] args) {
        System.out.println(new BigDecimal("1.1111010100101").setScale(2, RoundingMode.HALF_UP));
        A a = new A();
//        System.out.println(a);
    }
}
