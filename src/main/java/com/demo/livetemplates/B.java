/**
 * A.java
 * Created on  11/12/15 3:07 PM
 * modify on                user            modify content
 * 11/12/15 3:07 PM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.livetemplates.iface;

import org.apache.log4j.Logger;

/**
 * Created by micx  on 2015/12/11 3:07 PM.
 */
public class B implements A {

    private static final Logger logger = Logger.getLogger(B.class);
    public static void main(String[] args) {
        B b  = new B();
        b.getClass().getInterfaces();

    }
}
