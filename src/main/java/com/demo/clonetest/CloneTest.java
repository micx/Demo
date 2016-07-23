/**
 * CloneTest.java  
 * Created on  29/4/15 8:53 AM
 * modify on                user            modify content
 * 29/4/15 8:53 AM        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.clonetest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Created by micx  on 2015/04/29 8:53 AM.
 */
public class CloneTest implements Cloneable {

    private int x;
    private int y;
    private String msg;


    public static void main(String[] args) throws CloneNotSupportedException {
        CloneTest x = new CloneTest();
        x.setX(1);
        x.setY(2);
        x.setMsg("hello 1");
        assignTest( x);
        cloneTest( x);


    }

    private static void assignTest(CloneTest x) {

        System.out.println("assignTest");
        CloneTest y = x;

        y.setMsg("assign");

        System.out.println(x);
        System.out.println(y);
    }

    private static void cloneTest(CloneTest x) throws CloneNotSupportedException {
        System.out.println("cloneTest");


        CloneTest y = (CloneTest) x.clone();

        y.setMsg("clone");

        System.out.println(x);
        System.out.println(y);

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }
}
