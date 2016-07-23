/**
 * Client.java  
 * Created on  4/1/15 上午10:01
 * modify on                user            modify content
 * 4/1/15 上午10:01        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.callback.reg;

import java.util.Random;

/**
 * Created by micx  on 2015/01/04 上午10:01.
 */
public class Client extends Thread {
    private boolean sleep  = true;
    @Override
    public void run() {
        Random random = new Random();
        while(true) {
            for (int i = 0; i < 5; i++) {
                int userId = random.nextInt(100);
                ShareMem.register(userId);
                System.out.println("Thread:" + Thread.currentThread().getName() + "\tuserId: " + userId);
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
