/**
 * NumberTest.java  
 * Created on  27/5/15 3:15 PM
 * modify on                user            modify content
 * 27/5/15 3:15 PM        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.number;

import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;

/**
 * Created by micx  on 2015/05/27 3:15 PM.
 */
public class NumberTest {
    public static void main(String[] args) {

        String str = "12.1";
        System.out.println(NumberUtils.isNumber(str));
        BigDecimal bigDecimal = new BigDecimal(str);
        System.out.println(bigDecimal);



    }
}
