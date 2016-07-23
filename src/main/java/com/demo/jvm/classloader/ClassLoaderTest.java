/**
 * ClassLoaderTest.java
 * Created on  9/3/2016 5:00 PM
 * modify on                user            modify content
 * 9/3/2016 5:00 PM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.jvm.classloader;

import com.demo.jvm.classloader.entity.A;
import com.demo.jvm.classloader.entity.B;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by micx  on 2016/03/09 5:00 PM.
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        B b = new B();
        A a = new A();

        a.plus(1,2);
        b.plus(1,2);

        String str = "123";
        System.out.println(str.getClass().getClassLoader());

        List<A> list = new ArrayList<A>();
        System.out.println(list.getClass().getClassLoader());


    }
}
