/**
 * FactoryBeanProxy.java  
 * Created on  3/3/15 上午8:52
 * modify on                user            modify content
 * 3/3/15 上午8:52        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.callback.thread;

import com.demo.callback.call.Client;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by micx  on 2015/03/03 上午8:52.
 */
public class FactoryBeanProxy {
    public Object invoke(){
        FutureTask<String> futureTask = new FutureTask<String>(new Client());
        ThreadPool.add(futureTask);
        try {
            String ret = futureTask.get(1000, TimeUnit.MILLISECONDS);
            return ret;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return null;
    }
}
