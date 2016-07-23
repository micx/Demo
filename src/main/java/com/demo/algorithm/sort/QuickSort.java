/**
 * QuickSort.java
 * Created on  7/6/2016 8:56 PM
 * modify on                user            modify content
 * 7/6/2016 8:56 PM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.algorithm.sort;


import java.util.Arrays;
import java.util.List;

/**
 * Created by micx  on 2016/06/07 8:56 PM.
 */
public class QuickSort {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 234,12,32,45,23,56,56,545645,3,43,2, 4, 7,6, 43, 2, 3, 34);
//        List<Integer> list = Arrays.asList(1,1,1,1,1,1,1,1,1,11);
        quickSort(list);
        System.out.println(list);
    }

    public static void quickSort(List<Integer> list) {
        if (list != null) {
            quickSort(list, 0, list.size() - 1);
        }
    }

    private static void quickSort(List<Integer> list, int start, int end) {
        if (start >= end || list == null)
            return;
        int p = partition(list, start, end);
        quickSort(list, start, p - 1);
        quickSort(list, p + 1, end);
    }

    private static int partition(List<Integer> list, int start, int end) {
        int s = start + 1;
        int e = end;
        int tag = list.get(start);
        while (true) {
            while (list.get(s) <= tag && s < e) s++;
            while (list.get(e) >= tag && s < e) e--;
            if (s == e) {
                break;
            }
            swap(list, s, e);
        }
        if (tag <= list.get(s)){
            swap(list, start, s-1);
            return s-1;
        }else {
            swap(list, start, s);
            return s;
        }
    }

    private static void swap(List<Integer> list, int s, int e) {
        int tmp = list.get(s);
        list.set(s, list.get(e));
        list.set(e, tmp);
    }
}