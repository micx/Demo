/**
 * RefTest.java  
 * Created on  12/6/15 9:26 AM
 * modify on                user            modify content
 * 12/6/15 9:26 AM        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.common.test;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * Created by micx  on 2015/06/12 9:26 AM.
 */
public class RefTest {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();
        String str = "hello";
        modifyStr(str);

        list.add(str);
        modifyList(list);
        System.out.println(str);
        System.out.println(list);
    }

    private static void modifyList(List<String> list) {
        list.add("world");
        list = Arrays.asList("hi", "man");
    }

    private static void modifyStr(String str) {
        str = new String("hello");
    }
}
