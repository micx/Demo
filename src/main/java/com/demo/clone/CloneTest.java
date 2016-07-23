/**
 * CloneTest.java  
 * Created on  22/3/15 上午9:45
 * modify on                user            modify content
 * 22/3/15 上午9:45        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.clone;

import com.demo.clone.entity.A;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by micx  on 2015/03/22 上午9:45.
 */
public class CloneTest {
    public static void main(String[] args) {

        Map<A, String> map = new HashMap<A, String>();



        A a = new A();
        for (int i = 0; i < 4 ; i++) {
            a.setX(i);
            a.setY(i * i);
            a.setTx("" + i * i * i);
            map.put(a, i+"");
        }
        System.out.println(map);

        A b = new A();
        b.setX(2);
        b.setY(4);
        b.setTx("8");
        System.out.println(map.get(b));

        b.setX(3);
        b.setY(9);
        b.setTx("27");
        System.out.println(map.get(b));
    }
}
