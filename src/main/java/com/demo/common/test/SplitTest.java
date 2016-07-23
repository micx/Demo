/**
 * SplitTest.java  
 * Created on  20/1/15 上午10:34
 * modify on                user            modify content
 * 20/1/15 上午10:34        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.common.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by micx  on 2015/01/20 上午10:34.
 */
public class SplitTest {
    public static void main(String[] args) {
        String str = "http://chenxi.waimai.51ping.com:8080/activity/editstock?id=2&ac=2";

        Map<String,String> map = new HashMap<String, String>();
        String[] arr = str.split("\\?");
        if(arr.length == 2) {
            String[] params = arr[1].split("&");
            for (String param : params) {
                String[] strs = param.split("=");
                if (strs.length == 2) {
                    map.put(strs[0], strs[1]);
                }
            }
        }
        System.out.println(map);
    }
}
