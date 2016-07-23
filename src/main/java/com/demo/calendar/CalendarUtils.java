/**
 * CalendarUtils.java  
 * Created on  2028/8/14 下午1:50
 * modify on                user            modify content
 * 2028/8/14 下午1:50        chenxi.chen
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by chenxi.chen  on 2014/08/28 下午1:50.
 */
public class CalendarUtils {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date date = new Date();
            date.setHours(23);
            date.setMinutes(59);
            System.out.println(date);

        Calendar cal = Calendar.getInstance();
        Date endTime = cal.getTime();
        cal.add(Calendar.HOUR,-1);
        Date startTime = cal.getTime();
        System.out.println(startTime+"\t"+endTime);
    }
}
