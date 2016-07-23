/**
 * Test.java  
 * Created on  5/12/14 下午3:50
 * modify on                user            modify content
 * 5/12/14 下午3:50        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.thread.DateUtils;

import com.demo.thread.dateutil.DateUtils;

import java.text.ParseException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by micx  on 2014/12/05 下午3:50.
 */
public class Test {

    public static void main(String[] args) {
        final String patten1 = "yyyy-MM-dd";
        final String patten2 = "yyyy-MM";

        Thread t1 = new Thread() {

            @Override
            public void run() {
                try {
                    DateUtils.parse("1992-09-13", patten1);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t2 = new Thread() {

            @Override
            public void run() {
                try {
                    DateUtils.parse("2000-09", patten2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t3 = new Thread() {

            @Override
            public void run() {
                try {
                    DateUtils.parse("1992-09-13", patten1);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t4 = new Thread() {

            @Override
            public void run() {
                try {
                    DateUtils.parse("2000-09", patten2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t5 = new Thread() {


            @Override
            public void run() {
                try {
                    DateUtils.parse("2000-09-13", patten1);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t6 = new Thread() {

            @Override
            public void run() {
                try {
                    DateUtils.parse("2000-09", patten2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        };

        System.out.println("单线程执行: ");
        ExecutorService exec = Executors.newFixedThreadPool(1);
        exec.execute(t1);
        exec.execute(t2);
        exec.execute(t3);
        exec.execute(t4);
        exec.execute(t5);
        exec.execute(t6);
        exec.shutdown();

        sleep(1000);

        System.out.println("双线程执行: ");
        ExecutorService exec2 = Executors.newFixedThreadPool(3);
        exec2.execute(t1);
        exec2.execute(t2);
        exec2.execute(t3);
        exec2.execute(t4);
        exec2.execute(t5);
        exec2.execute(t6);
        exec2.shutdown();
    }

    private static void sleep(long millSec) {
        try {
            TimeUnit.MILLISECONDS.sleep(millSec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}