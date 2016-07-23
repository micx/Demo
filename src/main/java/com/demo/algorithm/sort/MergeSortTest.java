/**
 * MergeSortTest.java
 * Created on  7/6/2016 9:41 PM
 * modify on                user            modify content
 * 7/6/2016 9:41 PM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.algorithm.sort;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * Created by micx  on 2016/06/07 9:41 PM.
 */
public class MergeSortTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 234,12,32,45,23,56,56,545645,3,43,2, 4, 7,6, 43, 2, 3, 34);
//        List<Integer> list = Arrays.asList(1,1,1,1,1,1,1,1,1,11);
        List<Integer> integers = mergeSort(list);
        System.out.println(integers);
    }

    private static List<Integer> mergeSort(List<Integer> list) {
        if (list.size() <= 1){
            return list;
        }
        int mid = list.size()/2;
        List<Integer> left = mergeSort(list.subList(0, mid));
        List<Integer> right = mergeSort(list.subList(mid, list.size()));
        List<Integer> result = Lists.newArrayListWithCapacity(list.size());
        int l=0;
        int r = 0;
        while (l < left.size() && r < right.size()){
            int lv = left.get(l);
            int rv = right.get(r);
            if (lv > rv){
                result.add(rv);
                r++;
            }else{
                result.add(lv);
                l++;
            }
        }

        if (l < left.size()){
            result.addAll(left.subList(l, left.size()));
        }else {
            result.addAll(right.subList(r, right.size()));
        }
        return result;
    }
}
