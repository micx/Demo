/**
 * SpinLock1.java  
 * Created on  3/6/15 9:40 AM
 * modify on                user            modify content
 * 3/6/15 9:40 AM        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.concurrent.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 可重入
 * Created by micx  on 2015/06/03 9:40 AM.
 */
public class SpinLock1 {
    private AtomicReference<Thread> owner =new AtomicReference<Thread>();
    private int count =0;
    public void lock(){
        Thread current = Thread.currentThread();
        if(current==owner.get()) {
            count++;
            return ;
        }

        while(!owner.compareAndSet(null, current)){

        }
    }
    public void unlock (){
        Thread current = Thread.currentThread();
        if(current==owner.get()){
            if(count!=0){
                count--;
            }else{
                owner.compareAndSet(current, null);
            }

        }

    }
}
