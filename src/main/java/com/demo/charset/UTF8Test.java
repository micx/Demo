/**
 * UTF8Test.java  
 * Created on  29/12/14 下午5:59
 * modify on                user            modify content
 * 29/12/14 下午5:59        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.charset;

import com.google.common.base.Charsets;

/**
 * Created by micx  on 2014/12/29 下午5:59.
 */

public class UTF8Test {
    public static void main(String[] args) throws Exception {

        utf8SizeTest();

    }

    private static void utf8SizeTest() {
        String str = "秀沿西路 中海御景\uD850\uDEEE岸273楼1201室";

        String ascii = "12345abcde";
        showSize(ascii);

        String zh = "中国";
        showSize(zh);

        String mb4 = "\uD850\uDEEE";
        showSize(mb4);
    }

    private static void showSize(String str) {
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        System.out.println(str+":");
        System.out.println("bytes:");
        System.out.println( bytes2Hex(bytes));
        System.out.println("binary:");
        System.out.println( bytes2Binary(bytes));
        System.out.println("size:"+bytes.length+" byte\n");
    }

    private static String bytes2Hex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < bytes.length; ++i){
            sb.append("0x" + Integer.toHexString(0xFF & bytes[i]).toUpperCase()+"\t");
        }
        return sb.toString();
    }
    private static String bytes2Binary(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < bytes.length; ++i){
            sb.append(Integer.toBinaryString(0xFF & bytes[i]).toUpperCase()+"\t");
        }
        return sb.toString();
    }

}
