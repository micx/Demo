/**
 * Producer.java  
 * Created on  1/6/15 9:26 AM
 * modify on                user            modify content
 * 1/6/15 9:26 AM        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.concurrent.blockingqueue;

import java.util.concurrent.BlockingQueue;

/**
 * Created by micx  on 2015/06/01 9:26 AM.
 */
public class Producer implements Runnable {
    private BlockingQueue<Integer> queue;
    private int sum;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true) {
            try {
                int val = queue.take();
                sum += val;
                System.out.println(String.format("Thread:%s, sum=%d", Thread.currentThread().getName(), sum));
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
