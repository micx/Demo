/**
 * ServiceFutureFactory.java
 * Created on  29/6/2016 4:59 PM
 * modify on                user            modify content
 * 29/6/2016 4:59 PM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.future.proxy;

import java.util.concurrent.Future;

/**
 * Created by micx  on 2016/06/29 4:59 PM.
 */
public class ServiceFutureFactory {

    private static ThreadLocal<Future> threadFuture = new ThreadLocal<Future>();

    public static Future getFuture() {
        Future future = threadFuture.get();
        threadFuture.remove();
        return future;
    }

    public static void setFuture(Future future) {
        threadFuture.set(future);
    }

    public static void remove() {
        threadFuture.remove();
    }

}
