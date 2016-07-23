/**
 * ConcreteObserver.java  
 * Created on  6/1/15 下午2:28
 * modify on                user            modify content
 * 6/1/15 下午2:28        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.designpattern.observer;

/**
 * Created by micx  on 2015/01/06 下午2:28.
 */
public class ConcreteObserver implements Observer {

    private String name;
    private String status;

    public ConcreteObserver(String name, String status) {
        this.name = name;
        this.status = status;
    }

    @Override
    public void update() {
        System.out.println("name: "+name+", status: "+status);
    }
}
