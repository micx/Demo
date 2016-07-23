/**
 * IteratorTest.java
 * Created on  4/3/2016 2:39 PM
 * modify on                user            modify content
 * 4/3/2016 2:39 PM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.iterator;

import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;

/**
 * Created by micx  on 2016/03/04 2:39 PM.
 */
public class IteratorTest {
    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            if (next == 3){
                list.remove(next);
//                iterator.remove();
            }
        }
        System.out.println(list);
    }
}
