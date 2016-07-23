/**
 * VolatileExample.java
 * Created on  26/5/2016 2:56 PM
 * modify on                user            modify content
 * 26/5/2016 2:56 PM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.volati;

/**
 * Created by micx  on 2016/05/26 2:56 PM.
 */
public class VolatileExample extends Thread {
    //设置类静态变量,各线程访问这同一共享变量
    private static  boolean flag = false;

    //无限循环,等待flag变为true时才跳出循环
    public void run() {
        while (!flag) {
            int i=1;
        }
    }

    public static void main(String[] args) throws Exception {
        new VolatileExample().start();
        //sleep的目的是等待线程启动完毕,也就是说进入run的无限循环体了
        Thread.sleep(100);
        flag = true;
    }
}
