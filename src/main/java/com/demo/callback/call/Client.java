/**
 * Client.java  
 * Created on  4/1/15 上午9:44
 * modify on                user            modify content
 * 4/1/15 上午9:44        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.callback.call;

import java.util.concurrent.Callable;

/**
 * Created by micx  on 2015/01/04 上午9:44.
 */
public class Client implements MyCallInterface, Callable<String> {

    private int id;

    public Client() {
    }

    public Client(int id) {
        this.id = id;
    }

    @Override
    public void printName() {
        System.out.println("This is the client printName method");
    }

    @Override
    public String call() throws Exception {
        int sleep = (int) (Math.random()*1000);
        Thread.sleep(sleep);
        return "callable client - "+id;
    }
}
