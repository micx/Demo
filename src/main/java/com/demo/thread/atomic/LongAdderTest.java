/**
 * LongAdderTest.java  
 * Created on  30/3/15 8:33 AM
 * modify on                user            modify content
 * 30/3/15 8:33 AM        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.thread.atomic;

import com.demo.thread.ThreadPoolImpl;
import io.netty.util.internal.chmv8.LongAdder;

/**
 * Created by micx  on 2015/03/30 8:33 AM.
 */
public class LongAdderTest implements Runnable{
    private static final LongAdder longAdder = new LongAdder();
    long generateSerialNumber(){
        longAdder.increment();
        return longAdder.longValue();
    }
    public static void main(String[] args) {
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
