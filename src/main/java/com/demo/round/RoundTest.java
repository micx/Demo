/**
 * RoundTest.java  
 * Created on  5/1/15 下午6:15
 * modify on                user            modify content
 * 5/1/15 下午6:15        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.round;

/**
 * Created by micx  on 2015/01/05 下午6:15.
 */
public class RoundTest {
    public static void main(String[] args) {
        int x = (int)Math.ceil(1.0);
        int y = (int)Math.ceil(1.1);
        System.out.println(x);
        System.out.println(y);
        System.out.println(Math.ceil(1.1));
        System.out.println(Math.ceil(1.01));
        System.out.println(Math.ceil(1.6));
    }
}
