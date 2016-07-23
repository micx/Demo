/**
 * SemaphoreTest.java  
 * Created on  2/6/15 9:35 AM
 * modify on                user            modify content
 * 2/6/15 9:35 AM        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.concurrent.semahpore;

import com.demo.thread.ThreadPoolImpl;

/**
 * Created by micx  on 2015/06/02 9:35 AM.
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        BoundedHashSet<String> set = new BoundedHashSet<String>(10);
        ThreadPoolImpl.submit(new Adder(set));
        ThreadPoolImpl.submit(new Adder(set));
        ThreadPoolImpl.submit(new Remover(set));
//        ThreadPoolImpl.submit(new Adder(set));

    }
}
