/**
 * SDF.java  
 * Created on  4/12/14 下午4:52
 * modify on                user            modify content
 * 4/12/14 下午4:52        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.thread.sdf;

import java.text.SimpleDateFormat;

/**
 * Created by micx  on 2014/12/04 下午4:52.
 */
public class SDF extends Thread{
    private String name ;
    private static int num ;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public SDF(String name){
        this.name = name;
    }


    public void run() {
        while(true) {
            System.out.println(Thread.currentThread().getName()+"-------" +num);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        for(int i = 0;i<10;++i){
            new SDF(i+"").start();
        }
        while (true){
            num++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
