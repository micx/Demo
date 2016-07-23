/**
 * Test.java  
 * Created on  3/3/15 上午9:46
 * modify on                user            modify content
 * 3/3/15 上午9:46        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.thread.readerwriter;

/**
 * Created by micx  on 2015/03/03 上午9:46.
 */
public class Test {
    public  static void main(String args[]){
        System.currentTimeMillis();
        Buffer buffer=new Buffer();
        Thread t1=new Thread(new Writer(buffer));
        Thread t2=new Thread(new Writer(buffer));
        Thread t3=new Thread(new Reader(buffer));
        Thread t4=new Thread(new Reader(buffer));
        t1.start();
        t2.start();
        t3.start();
        t4.start();


    }
}
