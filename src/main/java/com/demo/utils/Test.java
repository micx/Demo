/**
 * Test.java  
 * Created on  23/12/14 下午2:15
 * modify on                user            modify content
 * 23/12/14 下午2:15        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.utils;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by micx  on 2014/12/23 下午2:15.
 */
public class Test {
    public static void main(String[] args) {
        int i = NumberUtils.toInt("abc");
        Map<Integer, Integer> map ;
        Integer x = 1;
        NumberUtils.isNumber("1.23.3");
        System.out.println(NumberUtils.isNumber(""));
        System.out.println(NumberUtils.isNumber("10.1"));
        System.out.println(NumberUtils.isNumber("1.23"));
        try {
            Class<ArrayList<String>> c = (Class<ArrayList<String>>)Class.forName("java.util.ArrayList");
            ArrayList<String> strings = c.newInstance();
            System.out.printf(strings.toString());
            System.out.printf(c.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
