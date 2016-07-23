/**
 * StringTest.java  
 * Created on  27/12/14 下午5:03
 * modify on                user            modify content
 * 27/12/14 下午5:03        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.string;

import java.util.Random;

/**
 * Created by micx  on 2014/12/27 下午5:03.
 */
public class StringTest {
    private static final Random random = new Random();
    private static final int len = 100000;
    private static String aa = "ab";

    public static void main(String[] args) {
//        String a = "a1";
//        String b = "a"+ 1;
//        System.out.println(a==b);
//
//
//
//
//        String a = "ab";
//        String bb = "b";
//        String b = "a"+ bb;    //编译器不能确定为常量
//        System.out.println(a==b);
//
//
//        String a = "ab";
//        final String bb = "b";
//        String b = "a"+ bb;    //bb加final后是常量，可以在编译器确定b
//        System.out.println(a==b);
//
//
//
//
//        String a = "ab";
//        final String bb = getBB();
//        String b = "a"+ bb;//bb是通过函数返回的，虽然知道它是final的，但不知道具体是啥，要到运行期才知道bb的值
//        System.out.println(a==b);
//
//
//
//        String s1 = "a";
//        String s2 = "b";
//        String s = s1 + s2;//+的用法
//        System.out.println(s == aa);
//        System.out.println(s.intern() == aa);//intern的含义

    }
    private static String getBB(){ return "b"; }


}
