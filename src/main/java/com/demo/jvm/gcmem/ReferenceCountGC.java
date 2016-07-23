/**
 * ReferenceCountGC.java
 * Created on  20/2/2016 3:18 PM
 * modify on                user            modify content
 * 20/2/2016 3:18 PM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.jvm.gcmem;

/**
 * Created by micx  on 2016/02/20 3:18 PM.
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * -XX:+PrintGCApplicationStoppedTime -XX:+PrintGCApplicationConcurrentTime
 */
public class ReferenceCountGC {
    public Object instance = null;
    private static final int _1MB = 1024 * 1024;
    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {
        ReferenceCountGC objA = new ReferenceCountGC();
        ReferenceCountGC objB = new ReferenceCountGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        System.gc();
    }
}
