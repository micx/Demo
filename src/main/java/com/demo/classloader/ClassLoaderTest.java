/**
 * ClassLoaderTest.java  
 * Created on  9/1/15 下午3:38
 * modify on                user            modify content
 * 9/1/15 下午3:38        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.classloader;

import java.util.ArrayList;

/**
 * Created by micx  on 2015/01/09 下午3:38.
 */
public class ClassLoaderTest {
    public static void main(String[] args) {

        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("os.arch"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.version"));

        String cls = "com.demo.classloader.A";
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        System.out.println(cl);
        System.out.println(cl.getParent());
        System.out.println(cl.getParent().getParent());
        System.out.println(ClassLoaderTest.class.getClassLoader());
        System.out.println(Object.class.getClassLoader());
        System.out.println(String.class.getClassLoader());
        System.out.println(ArrayList.class.getClassLoader());
        try {
            Class<?> clazz = cl.loadClass(cls);
            System.out.println("getName: "+clazz.getName());
            System.out.println("getCanonicalName: "+clazz.getCanonicalName());
            System.out.println("getSimpleName: "+clazz.getSimpleName());
            A a  = (A) clazz.newInstance();
            System.out.println(a.getX());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
