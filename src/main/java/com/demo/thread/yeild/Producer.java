/**
 * Producer.java
 * Created on  29/2/2016 6:23 PM
 * modify on                user            modify content
 * 29/2/2016 6:23 PM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.thread.yeild;

/**
 * Created by micx  on 2016/02/29 6:23 PM.
 */
class Producer extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("I am Producer : Produced Item " + i);
            Thread.yield();
        }
    }
}
