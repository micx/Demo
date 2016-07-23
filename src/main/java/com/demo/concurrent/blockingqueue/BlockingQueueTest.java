/**
 * BlockingQueueTest.java  
 * Created on  1/6/15 9:24 AM
 * modify on                user            modify content
 * 1/6/15 9:24 AM        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.concurrent.blockingqueue;

import com.demo.callback.thread.ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by micx  on 2015/06/01 9:24 AM.
 */
public class BlockingQueueTest implements Runnable {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue(50,true);

        ThreadPool.add(new Consumer(queue));
        ThreadPool.add(new Producer(queue));
        ThreadPool.add(new Producer(queue));
    }

    @Override
    public void run() {

    }
}
