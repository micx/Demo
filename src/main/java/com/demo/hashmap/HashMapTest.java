/**
 * HashMapTest.java  
 * Created on  8/12/14 上午9:28
 * modify on                user            modify content
 * 8/12/14 上午9:28        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.hashmap;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by micx  on 2014/12/08 上午9:28.
 */
public class HashMapTest {
    private int val;
    private static HashMap<Integer, String> hashMap = new HashMap<Integer, String>(20,1);
    private static int rand = 0;

    public HashMapTest(int val) {
        this.val = val;
    }

    public static void main(String[] args) {
        hashMap.put(0, "zero");
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
//        test6();
//        Object;
//        Hashtable;
        test7();
    }

    private static void test7() {
        A a = new A();
        Map<A, Integer> map = Maps.newHashMap();

        map.put(a, 1);
        a.setX(2);
        System.out.println(map.get(a));
    }

    private static class A{
        private int x;
        private int y;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof A)) return false;

            A a = (A) o;

            if (x != a.x) return false;
            return y == a.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    public static void test1() {
        try {
            hashMap.put(1, "one");
            Iterator<Map.Entry<Integer, String>> iterator = hashMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, String> next = iterator.next();
                System.out.println("test1: "+next);
                if (next.getKey() == 1){
                    iterator.remove();
                }
            }
        } catch (Exception e) {
            System.out.println("test1: failed");
        }
    }

    public static void test2() {
        try {
            Iterator<Map.Entry<Integer, String>> iterator = hashMap.entrySet().iterator();
            hashMap.put(2, "two");
            while (iterator.hasNext()) {
                Map.Entry<Integer, String> next = iterator.next();
                System.out.println("test2: "+next);
            }
        } catch (Exception e) {
            System.out.println("test2: failed");
        }
    }

    public static void test3() {
        try {
            Iterator<Map.Entry<Integer, String>> iterator = hashMap.entrySet().iterator();
            hashMap.put(0, "three");
            while (iterator.hasNext()) {
                Map.Entry<Integer, String> next = iterator.next();
                System.out.println("test3: "+next);
            }
        } catch (Exception e) {
            System.out.println("test3: failed");
        }
    }

    public static void test4() {
        try {
            Iterator<Map.Entry<Integer, String>> iterator = hashMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, String> next = iterator.next();
                System.out.println("test4: "+next);
                if (next.getKey() == 0) {
                    hashMap.put(4, "four");
                }
            }
        } catch (Exception e) {
            System.out.println("test4: failed");
        }
    }

    public static void test5() {
        try {
            Iterator<Map.Entry<Integer, String>> iterator = hashMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, String> next = iterator.next();
                System.out.println("test5: "+next);
                if (next.getKey() == 0) {
                    hashMap.remove(next.getKey());
                }
            }
        } catch (Exception e) {
            System.out.println("test5: failed");
        }
    }

    public static void test6() {
        try {
            Set<Map.Entry<Integer, String>> entries = hashMap.entrySet();
            hashMap.put(6, "six");
            for (Map.Entry<Integer, String> entry: entries){
                hashMap.put(2, "two +++");
                System.out.println("test6: "+ entry);
            }
        } catch (Exception e) {
            System.out.println("test6: failed");
        }
    }

}
