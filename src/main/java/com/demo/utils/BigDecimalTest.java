/**
 * BigDecimalTest.java  
 * Created on  17/12/14 下午4:34
 * modify on                user            modify content
 * 17/12/14 下午4:34        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.utils;

import java.math.BigDecimal;

/**
 * Created by micx  on 2014/12/17 下午4:34.
 */
public class BigDecimalTest {
    public static String getPrettyNumber(String number) {
        return BigDecimal.valueOf(Double.parseDouble(number))
                .stripTrailingZeros().toPlainString();
    }

    public static void main(String[] args) {
        String intNumber = "00012340";
        System.out.println(getPrettyNumber(intNumber));
        String doubleNumber = "00012.340";
        System.out.println(getPrettyNumber(doubleNumber));

        String eNumber = "0.00000";
        BigDecimal d = new BigDecimal(eNumber);
        System.out.println(d);
        System.out.println(d.stripTrailingZeros().toString());
        System.out.println(getPrettyNumber(eNumber));
    }
}
