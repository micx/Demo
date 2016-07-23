/**
 * SpinLock.java  
 * Created on  3/6/15 9:17 AM
 * modify on                user            modify content
 * 3/6/15 9:17 AM        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.concurrent.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by micx  on 2015/06/03 9:17 AM.
 */
public class SpinLock {


    private AtomicReference<Thread> sign =new AtomicReference<Thread>();


    public void lock(){
        Thread current = Thread.currentThread();
        int count = 0;
        while(!sign .compareAndSet(null, current)){
            ++count;
        }
        System.out.println(String.format("try %d times",count));
    }
    public void unlock (){
        Thread current = Thread.currentThread();
        sign .compareAndSet(current, null);
    }
}
