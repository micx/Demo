/**
 * Element.java
 * Created on  24/12/2015 2:38 PM
 * modify on                user            modify content
 * 24/12/2015 2:38 PM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.designpattern.visit.pattern;

/**
 * Created by micx  on 2015/12/24 2:38 PM.
 */
abstract class Element {
    public abstract void accept(IVisitor visitor);
    public abstract void doSomething();
}
