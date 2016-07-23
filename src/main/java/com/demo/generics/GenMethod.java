/**
 * GenMethod.java
 * Created on  5/6/2016 3:10 PM
 * modify on                user            modify content
 * 5/6/2016 3:10 PM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.generics;

import java.util.List;

/**
 * Created by micx  on 2016/06/05 3:10 PM.
 */
public class GenMethod {
    public static <T> void display(T t) {
        System.out.println(t.getClass());
    }

    public static void main(String[] args) {
        GenMethod.display("asdf");
        GenMethod.display(1);
        GenMethod.display(1L);
        GenMethod.display(new GenMethod());
    }
}
