/**
 * ProbTest.java  
 * Created on  12/3/15 上午10:41
 * modify on                user            modify content
 * 12/3/15 上午10:41        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.collectcard;

/**
 * Created by micx  on 2015/03/12 上午10:41.
 */
public class ProbTest {
    public static void main(String[] args) {
        int lt = 100000;
        int userId = 681494;
        int sum = 0;
        for(int loop = 0;loop < lt;loop++ ) {


            boolean[] arr = new boolean[7];

            int count = 0;
            while (true) {

                double rd = Math.random();
                if (rd < 0.005) {
                    arr[userId%7] = true;
                    continue;
                }

                int i = randomWord(userId);
                arr[i] = true;
                if (check(arr)) {
                    break;
                }
                count++;
            }
            System.out.println(count);
            sum+=count;
        }
        System.out.println("avg:"+1.0*sum/lt);
    }

    private static boolean check(boolean[] arr) {
        for(int i = 0;i<7;++i){
            if (!arr[i]){
                return false;
            }
        }
        return true;
    }

    private static int randomWord(int memberId) {
//        int wid = (memberId % 7 + (int) (Math.random() * 6) + 1) % 7;
        Integer[] wordArr = new Integer[6];
        int j=0;
        for (int i=0; i<7 ; i++ ){
            if (memberId%7 == i){
                continue;
            }
            wordArr[j] = i;
            j++;
        }
        int random = (int)(Math.random()*100);
        if (random<20){
            return wordArr[0];
        }else if (random>=20 && random<50){
            return wordArr[1];
        }else if (random>=50 && random<52){
            return wordArr[2];
        }else if (random>=52 && random<70){
            return wordArr[3];
        }else if (random>=70 && random<96){
            return wordArr[4];
        }else {
            return wordArr[5];
        }
    }
}
