/**
 * A.java  
 * Created on  13/1/15 下午5:03
 * modify on                user            modify content
 * 13/1/15 下午5:03        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.reflect;

import java.lang.reflect.Field;

/**
 * Created by micx  on 2015/01/13 下午5:03.
 */
public class A {
    private int x;
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        A a = new A();
        Field field = a.getClass().getDeclaredField("x");
        field.setAccessible(true);
        field.set(a, 1);
        Field f = a.getClass().getDeclaredField("x");
        f.setAccessible(true);
        System.out.println(f.get(a));
    }
}
