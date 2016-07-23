/**
 * TimeStamp.java  
 * Created on  30/10/14 上午9:50
 * modify on                user            modify content
 * 30/10/14 上午9:50        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.timer;

import org.joda.time.DateTime;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by micx  on 2014/10/30 上午9:50.
 */
public class TimeStamp {
    public static void main(String[] args) {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        date = timestamp;
        System.out.println(timestamp+"\t"+date);

        DateTime dateTime = new DateTime();
        date.setTime(dateTime.getMillis());
        System.out.println(dateTime.getMillis()+"\t"+date);



    }
}
