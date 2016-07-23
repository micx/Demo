/**
 * FutureTask.java
 * Created on  29/6/2016 3:06 PM
 * modify on                user            modify content
 * 29/6/2016 3:06 PM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.future.task;


import net.sf.cglib.proxy.MethodProxy;

import java.util.concurrent.Callable;

/**
 * Created by micx  on 2016/06/29 3:06 PM.
 */
public class TestCglibTask implements Callable {

    private Object obj;
    private MethodProxy prox;
    private Object[] params;

    public TestCglibTask(Object obj, MethodProxy prox, Object[] params) {
        this.obj = obj;
        this.prox = prox;
        this.params = params;
    }

    public Object call() throws Exception {
        try {
            Object o = prox.invokeSuper(obj, params);
            return o;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
