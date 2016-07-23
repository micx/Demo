/**
 * SlotTest.java
 * Created on  5/3/2016 9:04 AM
 * modify on                user            modify content
 * 5/3/2016 9:04 AM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.jvm.stack;

/**
 * -verbose:gc -Xms200M -Xmx200M -Xmn100M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * Created by micx  on 2016/03/05 9:04 AM.
 */
public class SlotTest {
    public static void main(String[] args) {
//        test0();
//        test1();
        test2();
//        test3();
//        System.gc();
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }

    private static void test0() {
        byte[] placeHolder = new byte[64 * 1024 * 1024];
        System.gc();

    }

    private static void test3() {
        byte[] placeHolder = new byte[64 * 1024 * 1024];
        placeHolder = null;
        System.gc();
    }

    private static void test1() {
        {
            byte[] placeHolder = new byte[64 * 1024 * 1024];
        }
        System.gc();
    }

    private static void test2() {

        {
            byte[] placeHolder = new byte[1 * 1024 * 1024];
            byte[] placeHolder1 = new byte[1 * 1024 * 1024];
            placeHolder = null;
            placeHolder1 = null;
        }

        System.gc();
        int a ;
        System.gc();
    }
}
