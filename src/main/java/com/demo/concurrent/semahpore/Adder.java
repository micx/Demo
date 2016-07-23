/**
 * Adder.java  
 * Created on  2/6/15 9:41 AM
 * modify on                user            modify content
 * 2/6/15 9:41 AM        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.concurrent.semahpore;

/**
 * Created by micx  on 2015/06/02 9:41 AM.
 */
public class Adder implements Runnable {
    private BoundedHashSet<String> set;

    public Adder(BoundedHashSet<String> set) {
        this.set = set;
    }

    @Override
    public void run() {
        while (true){
            String str = String.valueOf(Math.random());
            try {
                System.out.println("add value="+str);
                set.add(str);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
