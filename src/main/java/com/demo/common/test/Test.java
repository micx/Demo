/**
 * Test.java  
 * Created on  8/12/14 上午11:10
 * modify on                user            modify content
 * 8/12/14 上午11:10        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.common.test;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by micx  on 2014/12/08 上午11:10.
 */
public class Test
{
    public int add(Integer x, Integer y){
        return x+y;
    }
    public static void main(String[] args)
    {
//        test(4, 0);
        test();
    }

    private static void test() {
        int[] arr = new int[]{1,2,3,4,5};

        String join = StringUtils.join(arr, ",");
        System.out.println(join);
    }

    private static void test(int x, int y) {
        try{
            int a = x/y;
        }catch (Exception e){
            System.out.println("Exception");
        }
        finally {
            System.out.println("Finally");
        }

    }

    private static int generateLegalInfo(boolean hasPhysicalShop, boolean hasIDCard, boolean hasHygienicLicense, boolean hasBusinessLicense) {
        int ret = 0;
        if (hasPhysicalShop){
            ret = ret | 8;
        }
        if (hasIDCard){
            ret = ret | 4;
        }
        if (hasHygienicLicense){
            ret = ret | 2;
        }
        if (hasBusinessLicense){
            ret = ret | 1;
        }
        return ret;
    }

}
