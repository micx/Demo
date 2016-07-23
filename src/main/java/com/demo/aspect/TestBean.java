/**
 * TestBean.java  
 * Created on  14/2/15 下午1:03
 * modify on                user            modify content
 * 14/2/15 下午1:03        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.aspect;

/**
 * Created by micx  on 2015/02/14 下午1:03.
 */
public class TestBean {
    private String testStr = "testStr";

    public void test(){
        System.out.println("test");
    }

    public void invokeTestMethod(){
        System.out.println("running test start ...");
        this.test();
        System.out.println("running test end ...");
    }

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }

}
