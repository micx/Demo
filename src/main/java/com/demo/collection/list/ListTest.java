/**
 * ListTest.java  
 * Created on  26/2/15 下午4:44
 * modify on                user            modify content
 * 26/2/15 下午4:44        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by micx  on 2015/02/26 下午4:44.
 */
public class ListTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();//Arrays.asList(0,1,2,3,4,5,6,7,8,9);
        list.add(1);
        list.add(2);
        list.add(3);
        A a = new A();
        a.setList(list);

        List<Integer> list1 = a.getList();
        System.out.println(a.getList());
        list1.remove((Integer) 5);
        System.out.println(a.getList());

    }
}
