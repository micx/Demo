/**
 * CollectionTest.java  
 * Created on  15/12/14 上午9:38
 * modify on                user            modify content
 * 15/12/14 上午9:38        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.collection;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.*;

/**
 * Created by micx  on 2014/12/15 上午9:38.
 */
public class CollectionTest {
    public static void main(String[] args) {


//        multiMap();
//
//        others();


        List<Integer> list = Lists.newArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        HashSet<Integer> integers = Sets.newHashSet(list);
        System.out.println(integers);


    }

    private static void multiMap() {
        HashMultimap<Integer, Integer> multimap = HashMultimap.create();
        multimap.put(1,2);
        multimap.put(1,3);
        multimap.put(1,4);
        multimap.put(1,2);
        System.out.println(multimap);
        System.out.println(multimap.get(1));
        System.out.println(multimap.get(2).contains(1));

    }

    private static void others() {

        List arrayList = new ArrayList<String>();
        List linkedList = new LinkedList();

        Set set = new HashSet();
        Queue arrayDeque = new ArrayDeque();
        Queue priorityQueue = new PriorityQueue<String>();

        Map<String,String> hashMap = new HashMap<String, String>();
        Map<String,String> treeMap = new TreeMap<String, String>();
        Map<String,String> hashtable = new Hashtable<String, String>();

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
    }
}
