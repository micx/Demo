/**
 * Visitor.java
 * Created on  24/12/2015 2:39 PM
 * modify on                user            modify content
 * 24/12/2015 2:39 PM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.designpattern.visit.pattern;

/**
 * Created by micx  on 2015/12/24 2:39 PM.
 */
class Visitor implements IVisitor {

    public void visit(ConcreteElement1 el1) {
        el1.doSomething();
    }

    public void visit(ConcreteElement2 el2) {
        el2.doSomething();
    }
}
