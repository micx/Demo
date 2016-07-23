/**
 * ShareMem.java  
 * Created on  4/1/15 上午10:01
 * modify on                user            modify content
 * 4/1/15 上午10:01        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.callback.reg;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by micx  on 2015/01/04 上午10:01.
 */
public class ShareMem extends Thread{

    private static List<Integer> list = new ArrayList<Integer>();
    private static Hashtable<Integer, Date> map = new Hashtable<Integer, Date>();

    public static void init(){

        ExecutorService executor = Executors.newCachedThreadPool();

        executor.execute(new ShareMem());
    }

    @Override
    public void run() {

        while(true) {
            Date date = new Date();
            list.clear();
            map.clear();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Set<Map.Entry<Integer, Date>> entries = map.entrySet();
            for(Map.Entry<Integer, Date> entry : entries){
                if(date.getTime() - entry.getValue().getTime() < 2000){
                    list.add(entry.getKey());
                }
            }
            System.out.println("date: " + date);
            System.out.println(list);
        }
    }

    public static void register(int userId){
        map.put(userId, new Date());
    }
}
