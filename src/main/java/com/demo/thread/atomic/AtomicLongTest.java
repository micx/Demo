/**
 * AtomicLongTest.java  
 * Created on  29/3/15 9:37 PM
 * modify on                user            modify content
 * 29/3/15 9:37 PM        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.thread.atomic;

import com.demo.thread.ThreadPoolImpl;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by micx  on 2015/03/29 9:37 PM.
 */
public class AtomicLongTest implements Runnable{
    private static final AtomicLong nextSerialNumber = new AtomicLong();
    long generateSerialNumber(){ return nextSerialNumber.getAndIncrement();}
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.get(0);

        for (int i = 0; i < 10; i++) {
            AtomicLongTest test = new AtomicLongTest();
            ThreadPoolImpl.submit(test);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "\t" + generateSerialNumber());
        }
    }
}
