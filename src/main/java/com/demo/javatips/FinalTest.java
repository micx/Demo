/**
 * FinalTest.java  
 * Created on  25/11/14 下午4:08
 * modify on                user            modify content
 * 25/11/14 下午4:08        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.javatips;

import clover.org.apache.commons.lang.builder.ToStringBuilder;
import clover.org.apache.commons.lang.builder.ToStringStyle;

/**
 * Created by micx  on 2014/11/25 下午4:08.
 */
public class FinalTest {
    private final String S = "final实例变量S";
    private final int A = 100;
    public final int B = 90;

    public static final int C = 80;
    private static final int D = 70;

    public static String str;

    public final int E; //final空白,必须在初始化对象的时候赋初值

    public FinalTest(int x) {
        E = x;
    }

    public static void main(String[] args) {
        FinalTest test = new FinalTest(1);
        FinalTest.str = "hello";
        System.out.println(test);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
