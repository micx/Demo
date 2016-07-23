/**
 * YieldExample.java
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
public class YieldExample {
    public static void main(String[] args) {
        Thread producer = new Producer();
        Thread producer1 = new Producer();
        Thread consumer = new Consumer();

        producer.setPriority(Thread.MIN_PRIORITY); //Min Priority
        producer1.setPriority(5); //Min Priority
        consumer.setPriority(Thread.MAX_PRIORITY); //Max Priority

        producer.start();
        producer1.start();
        consumer.start();
    }
}
