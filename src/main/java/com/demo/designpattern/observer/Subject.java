/**
 * Subject.java  
 * Created on  6/1/15 下午2:22
 * modify on                user            modify content
 * 6/1/15 下午2:22        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by micx  on 2015/01/06 下午2:22.
 */
public interface Subject {
     List<Observer> observers = new ArrayList<Observer>();

     void attach(Observer observer);

     void detach(Observer observer);

     void notifyobserver();

}
