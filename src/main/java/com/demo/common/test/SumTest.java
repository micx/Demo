/**
 * SumTest.java  
 * Created on  9/3/15 上午9:12
 * modify on                user            modify content
 * 9/3/15 上午9:12        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.common.test;

/**
 * Created by micx  on 2015/03/09 上午9:12.
 */
public class SumTest {
    public static void main(String[] args) {
        sum_1();
        sum_2();
    }

    private static void sum_2() {
        long start = System.currentTimeMillis();
        long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        long cost = System.currentTimeMillis() - start;
        System.out.println("sum-2 cost: " + cost + "ms");
        System.out.println(sum);
    }

    private static void sum_1() {
        long start = System.currentTimeMillis();
        Long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        long cost = System.currentTimeMillis() - start;
        System.out.println("sum-1 cost: " + cost + "ms");
        System.out.println(sum);
    }
}
