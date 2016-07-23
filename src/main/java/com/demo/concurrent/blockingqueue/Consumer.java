/**
 * Consumer.java  
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
public class Consumer implements Runnable {
    private BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            int val = (int) (Math.random() * 100);
            try {
                queue.put(val);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
