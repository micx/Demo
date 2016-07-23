/**
 * charset.java  
 * Created on  29/12/14 上午11:32
 * modify on                user            modify content
 * 29/12/14 上午11:32        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.common.test;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/**
 * Created by micx  on 2014/12/29 上午11:32.
 */
public class charset {
    public static void main(String[] args) {
        String str = "秀沿西路 中海御景\uD850\uDEEE岸273楼1201室";
        System.out.println(encodeCheck(str));
    }
    private static boolean encodeCheck(String ori) {
        try {
            byte[] bytes = ori.getBytes("utf-8");
            ByteArrayOutputStream bos = new ByteArrayOutputStream(bytes.length);
            for(int i=0; i< bytes.length; i++) {
                if( (bytes[i] & 0xf8 ) == 0xf0) {
                    i += 3 ;
                    return false;
                } else {
                    bos.write(bytes[i]);
                }
            }
            if(bos.size() != bytes.length) {
                return false;
            }
        } catch (UnsupportedEncodingException e) {
        }
        return true;
    }
}
