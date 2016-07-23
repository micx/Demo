/**
 * TestAllocation.java
 * Created on  3/2/2016 4:27 PM
 * modify on                user            modify content
 * 3/2/2016 4:27 PM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.jvm.gcmem;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by micx  on 2016/02/03 4:27 PM.
 *
 */
public class TestAllocation {
    public static final int  _1MB = 1024 * 1024;
    public static void main(String[] args) {
//        System.gc();
        List<Integer> list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(1);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        testAllocation();
//        testPretenureSizeThreshold();
//        testTenuringThreshold();

    }


    /**
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:MaxTenURingThreshold=1
     * -XX:+PrintTenuringDistribution
     * -XX:+UseConcMarkSweepGC
     */
    private static void testTenuringThreshold() {
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];

    }

    /**
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:PretenureSizeThreshold=3145728
     */
    private static void testPretenureSizeThreshold() {
        byte[] allocation;
        allocation = new byte[4 * _1MB];
    }

    /**
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    private static void testAllocation() {
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1 = new byte[4 * _1MB];
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[2 * _1MB]; // 出现一次Minor GC
    }
}
