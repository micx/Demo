/**
 * Test.java  
 * Created on  6/1/15 下午2:33
 * modify on                user            modify content
 * 6/1/15 下午2:33        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.designpattern.observer;

/**
 * Created by micx  on 2015/01/06 下午2:33.
 */
public class Test {
    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();

        subject.attach(new ConcreteObserver("A","1"));
        subject.attach(new ConcreteObserver("B","2"));
        subject.attach(new ConcreteObserver("C","3"));

        subject.notifyobserver();
    }
}
