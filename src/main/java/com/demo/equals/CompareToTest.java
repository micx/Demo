/**
 * CompareToTest.java  
 * Created on  12/3/15 上午9:05
 * modify on                user            modify content
 * 12/3/15 上午9:05        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.equals;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by micx  on 2015/03/12 上午9:05.
 */
public class CompareToTest {
    public static void main(String[] args) {

        BigDecimal one = new BigDecimal("1.0");
        BigDecimal two = new BigDecimal("1.00");

        Set<BigDecimal> hashSet = new HashSet<BigDecimal>();
        Set<BigDecimal> treeSet = new TreeSet<BigDecimal>();

        hashSet.add(one);
        hashSet.add(two);
        treeSet.add(one);
        treeSet.add(two);

        System.out.println("compare:\t" + one.compareTo(two));
        System.out.println("equals:\t" + one.equals(two));
        System.out.println("hashSet:\t" + hashSet.size());
        System.out.println("treeSet:\t" + treeSet.size());

    }
}
