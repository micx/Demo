/**
 * TestProxy.java  
 * Created on  16/1/15 上午9:18
 * modify on                user            modify content
 * 16/1/15 上午9:18        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.proxy.jdk;

/**
 * Created by micx  on 2015/01/16 上午9:18.
 */
public class TestProxy {

    public static void main(String[] args) {
        BookFacadeProxy proxy = new BookFacadeProxy();
        BookFacade bookProxy = (BookFacade) proxy.bind(new BookFacadeImpl());
        bookProxy.addBook();

        bookProxy.readBook();
    }

}
