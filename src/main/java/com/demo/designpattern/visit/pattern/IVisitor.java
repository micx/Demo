/**
 * IVisitor.java
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
interface IVisitor {
    public void visit(ConcreteElement1 el1);
    public void visit(ConcreteElement2 el2);
}
