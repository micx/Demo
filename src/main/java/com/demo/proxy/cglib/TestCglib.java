/**
 * TestCglib.java  
 * Created on  16/1/15 上午9:28
 * modify on                user            modify content
 * 16/1/15 上午9:28        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.proxy.cglib;

/**
 * Created by micx  on 2015/01/16 上午9:28.
 */
public class TestCglib {
    public static void main(String[] args) {
        BookFacadeCglib cglib=new BookFacadeCglib();
        BookFacadeImpl1 bookCglib=(BookFacadeImpl1)cglib.getInstance(new BookFacadeImpl1());
        bookCglib.addBook();
    }
}
