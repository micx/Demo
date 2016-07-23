/**
 * SyncMethodTest.java
 * Created on  22/12/2015 11:49 AM
 * modify on                user            modify content
 * 22/12/2015 11:49 AM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.synch;

/**
 * Created by micx  on 2015/12/22 11:49 AM.
 */
public class SyncMethodTest implements Runnable{
    public static void main(String[] args) {

    }


    public synchronized void A(){
        System.out.println("method A");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void B(){
        System.out.println("method A");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {

    }
}
