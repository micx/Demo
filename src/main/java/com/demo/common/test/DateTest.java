/**
 * DateTest.java  
 * Created on  4/1/15 下午5:09
 * modify on                user            modify content
 * 4/1/15 下午5:09        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.common.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by micx  on 2015/01/04 下午5:09.
 */
public class DateTest {
    public static void main(String[] args) {
        SimpleDateFormat sdf1= new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            String ymd = sdf1.format(new Date());
            Date date = sdf2.parse(ymd+" "+"11:00:12");
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
