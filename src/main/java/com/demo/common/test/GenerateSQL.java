/**
 * GenerateSQL.java  
 * Created on  5/3/15 上午10:50
 * modify on                user            modify content
 * 5/3/15 上午10:50        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.common.test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by micx  on 2015/03/05 上午10:50.
 */
public class GenerateSQL {
    static String pattern = "INSERT INTO `TA_ActivityShop` (`ActivityID`, `ShopID`, `MaxJoin`, `CityID`, `Status`,  `ReferID`, `Type`, `CurrentJoin`)\n" +
            "VALUES\n" +
            "\t( 20, 0, 0, %d, 1, 0, 0, 0);";
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,21,22,23,24,25,26,27,28,29,30,31,33,34,35,36,38,41,42,43,44,45,46,47,50,58,59,61,62,64,65,68,69,70,71,72,74,77,78,79,80,81,84,86,88,90,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,125,127,128,129,130,131,132,133,134,135,136,137,138,140,141,142,143,144,145,146,147,148,149,150,151,152,153,155,156,157,158,159,160,161,162,163,164,166,167,169,172,173,174,175,177,178,179,180,181,182,183,184,185,186,188,192,193,194,195,196,197,198,199,200,201,203,204,205,206,207,208,209,210,211,212,213,214,219,220,221,222,224,225,226,227,228,230,232,233,234,235,238,240,241,242,244,245,246,247,249,251,252,257,258,261,262,264,265,267,268,269,270,272,273,274,277,279,291,292,294,295,297,299,313,321,325,329,339,344,345,358,385,394,402,408,416,421,423,433,868,904,981,1008,1009,1015,1118);
        System.out.println(list.size());
        for(Integer i : list){
//            System.out.println(String.format(pattern, i));
        }
    }
}
