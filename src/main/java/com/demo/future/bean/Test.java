/**
 * Test.java
 * Created on  29/6/2016 3:12 PM
 * modify on                user            modify content
 * 29/6/2016 3:12 PM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.future.bean;

/**
 * Created by micx  on 2016/06/29 3:12 PM.
 */
public class Test implements TestIface {
    public Test() {
    }

    public int add(int x, int y){
        return x+y;
    }
    public int multi(int x, int y){
        return x*y;
    }
}
