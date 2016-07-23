/**
 * MapTest.java  
 * Created on  2/7/15 9:58 AM
 * modify on                user            modify content
 * 2/7/15 9:58 AM        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.common.test;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by micx  on 2015/07/02 9:58 AM.
 */
public class MapTest {
    public static void main(String[] args) {
        Map<Integer, String> map = Maps.newHashMap();
        map.put(1,"1");
        map.put(2,"11");
        map.put(3,"111");
        map.put(4,"1111");

        for (String val: map.values()){
            System.out.println(val);
        }
    }
}
