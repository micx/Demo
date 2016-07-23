/**
 * ConcreteSubject.java  
 * Created on  6/1/15 下午2:25
 * modify on                user            modify content
 * 6/1/15 下午2:25        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.designpattern.observer;

/**
 * Created by micx  on 2015/01/06 下午2:25.
 */
public class ConcreteSubject implements Subject {
    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyobserver() {
        for (Observer ob : observers){
            ob.update();
        }
    }
}
