/**
 * ReentryTest.java  
 * Created on  3/6/15 9:41 AM
 * modify on                user            modify content
 * 3/6/15 9:41 AM        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.concurrent.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by micx  on 2015/06/03 9:41 AM.
 */
public class ReentryTest implements Runnable{

        ReentrantLock lock = new ReentrantLock();
        SpinLock spinLock = new SpinLock();
        SpinLock1 spinLock1 = new SpinLock1();

        public void SpinLock1Get() {
            spinLock1.lock();
            System.out.println(String.format("SpinLock1Get:%d",Thread.currentThread().getId()));
            SpinLock1Set();
            spinLock1.unlock();
        }

        public void SpinLock1Set() {
            spinLock1.lock();
            System.out.println(String.format("SpinLock1Set:%d", Thread.currentThread().getId()));
            spinLock1.unlock();
        }

        public void SpinLockGet() {
            spinLock.lock();
            System.out.println(String.format("SpinLockGet:%d", Thread.currentThread().getId()));
            SpinLockSet();
            spinLock.unlock();
        }

        public void SpinLockSet() {
            spinLock.lock();
            System.out.println(String.format("SpinLockSet:%d", Thread.currentThread().getId()));
            spinLock.unlock();
        }

        public void ReentrantLockGet() {
            lock.lock();
            System.out.println(String.format("ReentrantLockGet:%d", Thread.currentThread().getId()));
            ReentrantLockSet();
            lock.unlock();
        }

        public void ReentrantLockSet() {
            lock.lock();
            System.out.println(String.format("ReentrantLockSet:%d", Thread.currentThread().getId()));
            lock.unlock();
        }

        public synchronized void synchronizedGet(){
            System.out.println(String.format("synchronizedGet:%d", Thread.currentThread().getId()));
            synchronizedSet();
        }

        public synchronized void synchronizedSet(){
            System.out.println(String.format("synchronizedSet:%d", Thread.currentThread().getId()));
        }

        @Override
        public void run() {
//            ReentrantLockGet();
//            synchronizedGet();
//            SpinLockGet();//dead lock
            SpinLock1Get();
        }
        public static void main(String[] args) {
            ReentryTest ss=new ReentryTest();
            new Thread(ss).start();
            new Thread(ss).start();
            new Thread(ss).start();
        }
    }

