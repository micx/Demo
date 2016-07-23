/**
 * Caller.java  
 * Created on  4/1/15 上午9:43
 * modify on                user            modify content
 * 4/1/15 上午9:43        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.callback.call;

/**
 * Created by micx  on 2015/01/04 上午9:43.
 */
public class Caller {
    private MyCallInterface callInterface;

    public Caller() {
    }

    public void setCallFunc(MyCallInterface callInterface) {
        this.callInterface = callInterface;
    }

    public void call() {
        callInterface.printName();
    }
}
