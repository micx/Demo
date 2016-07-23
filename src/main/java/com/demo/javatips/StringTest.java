/**
 * StringTest.java
 * Created on  5/1/2016 7:12 PM
 * modify on                user            modify content
 * 5/1/2016 7:12 PM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.javatips;

/**
 * Created by micx  on 2016/01/05 7:12 PM.
 */
public class StringTest {
//    static final int MAX = 1000 * 10000;
//    static final String[] arr = new String[MAX];
//
//    public static void main(String[] args) throws Exception {
//        Integer[] DB_DATA = new Integer[10];
//        Random random = new Random(10 * 10000);
//        for (int i = 0; i < DB_DATA.length; i++) {
//            DB_DATA[i] = random.nextInt();
//        }
//        long t = System.currentTimeMillis();
//        for (int i = 0; i < MAX; i++) {
//            arr[i] = new String(String.valueOf(DB_DATA[i % DB_DATA.length]));
////            arr[i] = new String(String.valueOf(DB_DATA[i % DB_DATA.length])).intern();
//        }
//
//        System.out.println((System.currentTimeMillis() - t) + "ms");
//        System.gc();
//    }



    public static void main(String[] args) {
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
    }

}
