/**
 * FutureTest.java  
 * Created on  1/3/15 下午4:45
 * modify on                user            modify content
 * 1/3/15 下午4:45        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.future;

import com.demo.future.bean.Test;
import com.demo.future.bean.TestIface;
import com.demo.future.proxy.CommonCglib;
import com.demo.future.proxy.ServiceFutureFactory;

import java.util.concurrent.Future;

/**
 * Created by micx  on 2015/03/01 下午4:45.
 */
public class FutureTest {
    public static void main(String[] args) {
        CommonCglib<Test> proxy = new CommonCglib<Test>();
        TestIface test = proxy.getInstance(new Test());

        test.add(2,3);
        Future future = ServiceFutureFactory.getFuture();
        test.multi(2,3);
        Future future1 = ServiceFutureFactory.getFuture();
        try {
            Integer rep = (Integer) future.get();
            System.out.println(rep);
            Integer rep2 = (Integer) future1.get();
            System.out.println(rep2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
