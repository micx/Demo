/**
 * PQueue.java
 * Created on  8/6/2016 10:01 PM
 * modify on                user            modify content
 * 8/6/2016 10:01 PM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.thread.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by micx  on 2016/06/08 10:01 PM.
 */
public class PQueue {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue queue   = new PriorityBlockingQueue();
        queue.put("A");
        queue.put("C");
        queue.put("B");
        queue.put("D");
        queue.put("Z");
        queue.put("H");
        queue.put("a");

        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
