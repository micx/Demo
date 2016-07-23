/**
 * Test.java  
 * Created on  13/3/15 下午12:08
 * modify on                user            modify content
 * 13/3/15 下午12:08        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.md5;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by micx  on 2015/03/13 下午12:08.
 */
public class Test {
    public static void main(String[] args) {
        String openId = "oGT4ct_wa-LtFi-T9vYHlqYlBhQo";
        String salt = "dianping";
        String result = "37ec5defb5d84f495cf08fef6d31116a";
        String md5Hex = DigestUtils.md5Hex(openId + salt);
        System.out.println(md5Hex);

        byte[] md5 = DigestUtils.md5(openId + salt);
        for (int i = 0; i < md5.length; i++) {
            System.out.print(md5[i]+" ");
        }
        System.out.println();
    }
}
