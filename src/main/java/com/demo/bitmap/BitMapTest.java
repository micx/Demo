/**
 * BitMapTest.java  
 * Created on  27/12/14 下午5:53
 * modify on                user            modify content
 * 27/12/14 下午5:53        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.bitmap;

import sun.jvm.hotspot.utilities.BitMap;

/**
 * Created by micx  on 2014/12/27 下午5:53.
 */
public class BitMapTest {
    public static void main(String[] args) {
        BitMap bitMap = new BitMap(20);
        bitMap.atPut(3,true);
        bitMap.atPut(1,true);
        bitMap.atPut(4,true);
        bitMap.atPut(2,true);
        bitMap.atPut(9,true);
        bitMap.atPut(5,true);
        bitMap.atPut(6,true);

        for(int i=0;i<bitMap.size();++i){
            if(bitMap.at(i)) {
                System.out.println(i);
            }
        }
    }
}
