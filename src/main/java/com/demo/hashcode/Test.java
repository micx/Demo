/**
 * Test.java  
 * Created on  8/3/15 上午10:09
 * modify on                user            modify content
 * 8/3/15 上午10:09        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.hashcode;

/**
 * Created by micx  on 2015/03/08 上午10:09.
 */
public class Test {
    public static void main(String[] args) {
        String str = new String("micx");
        String str_1 = new String("hello");

        Object obj = new Object();
        System.out.println(str.hashCode());
        System.out.println(str_1.hashCode());
    }
}
