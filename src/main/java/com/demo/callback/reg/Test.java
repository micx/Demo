/**
 * Test.java  
 * Created on  4/1/15 上午10:00
 * modify on                user            modify content
 * 4/1/15 上午10:00        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.callback.reg;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by micx  on 2015/01/04 上午10:00.
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {

        ShareMem.init();
        ExecutorService executor = Executors.newCachedThreadPool();

        executor.execute(new Client());
        executor.execute(new Client());

        executor.shutdown();
    }
}
