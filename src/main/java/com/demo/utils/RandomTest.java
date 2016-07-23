/**
 * RandomTest.java  
 * Created on  19/12/14 上午11:27
 * modify on                user            modify content
 * 19/12/14 上午11:27        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by micx  on 2014/12/19 上午11:27.
 */
public class RandomTest {
    public static int getRandomTicket(final Map<Integer, Integer> map) {
        final int SIZE = 100; 	//基数
        int result = 0; // 默认没中奖
        if(map == null || map.size() == 0){
            return result;
        }
        // 获得一个随机数
        Random random = new Random();
        int randomNumber = random.nextInt(SIZE);
        // 计算随机数落入哪个区间
        int range = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            range += entry.getValue();
            if (randomNumber < range) {
                result = entry.getKey();
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Map map = new HashMap<Integer, Integer>();
        map.put(1,40);
        map.put(2,30);
        map.put(3,20);
        map.put(4,10);

        int[] result = new int[5];
        for(int i=0;i<10000;++i){
            result[getRandomTicket(map)]++;
        }
        for(int i=0;i<5;++i){
            System.out.println(result[i]);
        }
    }
}
