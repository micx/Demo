/**
 * SQLTest.java  
 * Created on  25/12/14 下午2:55
 * modify on                user            modify content
 * 25/12/14 下午2:55        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.sql;

import com.google.common.base.Charsets;

import java.util.Random;

/**
 * Created by micx  on 2014/12/25 下午2:55.
 */
public class SQLTest {
    public static void main(String[] args) {

        String str = "￨ﾥ\uFFBF￦ﾞﾗ";
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        System.out.println(new String(bytes, Charsets.UTF_8));


        String bs = enCode(str);
        System.out.println("bytes2String:\t"+bs);
        String bb = deCode("￨ﾥ\uFFBF￦ﾞﾗ");
        System.out.println(bb);


        testString_StringBuilder();
    }

    private static void testString_StringBuilder() {
        String testStr = "";
        Random random = new Random();
        for(int i=0;i<10000;++i){
            testStr += random.nextLong();
        }


        enCode(testStr);
        enCodeWithStringBuilder(testStr);
        enCodeWithStringBuffer(testStr);




    }

    private static String enCode(String str) {
        long start = System.currentTimeMillis();
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        String ret ="";
        for(int i=0;i<bytes.length;++i){
            ret += (char)bytes[i];
        }
        long cost = System.currentTimeMillis() - start;
        System.out.println("String cost:" + cost+"ms");
        return ret;
    }

    private static String enCodeWithStringBuffer(String str) {
        long start = System.currentTimeMillis();
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        StringBuffer ret = new StringBuffer();
        for(int i=0;i<bytes.length;++i){
            ret.append((char)bytes[i]);
        }
        long cost = System.currentTimeMillis() - start;
        System.out.println("StringBuffer cost:" + cost+"ms");
        return ret.toString();
    }
    private static String enCodeWithStringBuilder(String str) {
        long start = System.currentTimeMillis();
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        StringBuilder ret = new StringBuilder();
        for(int i=0;i<bytes.length;++i){
            ret.append((char)bytes[i]);
        }
        long cost = System.currentTimeMillis() - start;
        System.out.println("StringBuilder cost:" + cost+"ms");
        return ret.toString();
    }

    private static String deCode (String str) {
        char[] chars = str.toCharArray();
        byte[] bytes = new byte[chars.length];
        for(int i=0;i<chars.length; ++i){
            bytes[i] = (byte)chars[i];
        }
        return new String(bytes,Charsets.UTF_8);
    }
}
