package com.demo;

import com.google.common.collect.Lists;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Test {
    private static int size = 1;
    private static int PAGE_SIZE = 3;

    private static List<Integer> list = Lists.newArrayList(size);
    public static void main(String[] args){
//        page();
//       strIntern();
//        test1();
//        System.out.println(String.format("%02d", 1));
//        System.out.println(String.format("%02d", 10));
//
//
//        Calendar cal =  Calendar.getInstance();
//        cal.add(Calendar.MINUTE, 120);
//        System.out.println(cal.getTime());

        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);


        Date tim1 = cal.getTime();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        Date tim2 = cal.getTime();
        System.out.println(tim1);
        System.out.println(tim2);


//        Calendar cal = Calendar.getInstance();
//        cal.add(Calendar.HOUR, -2);
//        Date endTime = cal.getTime();
//        cal.add(Calendar.MINUTE, -10);
//        Date startTime = cal.getTime();
//        System.out.println(startTime);
//        System.out.println(endTime);
    }

    private static void test1() {

        list.add(3);
        list.add(1);
        list.add(5);
        list.add(7);
        list.add(4);
        list.add(10);
        Collections.sort(list);
        System.out.println(list.indexOf(list.size() - 1));
    }

    private static void strIntern() {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str3 = new StringBuilder("Stri").append("ng").toString();
        System.out.println(str3.intern() == str3);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }

    private static void page() {
        List list = Lists.newArrayList();
        list.add(1);
        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        list.add(6);
//        list.add(7);
//        list.add(8);
//        list.add(9);
//        list.add(10);
//        list.add(11);
//        list.add(12);

        int size = list.size();
        int pageCnt = (int) Math.ceil(1.0 * size/PAGE_SIZE);
        for (int i = 0; i < pageCnt; i++) {
            int start = 0 + i*PAGE_SIZE;
            int end = Math.min(start + PAGE_SIZE, size);
            List list1 = list.subList(start, end);
            System.out.println(list1);
        }
    }

}