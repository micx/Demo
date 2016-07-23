/**
 * blockqueue.java
 * Created on  18/12/2015 5:40 PM
 * modify on                user            modify content
 * 18/12/2015 5:40 PM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by micx  on 2015/12/18 5:40 PM.
 */
public class Blockqueue {

    final static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static BlockingQueue<Integer> bq = new LinkedBlockingDeque<Integer>();

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch=new CountDownLatch(2);//两个工人的协作
        Worker worker1=new Worker("zhang san", 1, latch);
        Worker worker2=new Worker("li si", 2, latch);
        worker1.start();//
        worker2.start();//
        latch.await();//等待所有工人完成工作
        System.out.println("all work done at "+sdf.format(new Date()));
    }


    static class Worker extends Thread{
        String workerName;
        int workTime;
        CountDownLatch latch;
        public Worker(String workerName ,int workTime ,CountDownLatch latch){
            this.workerName=workerName;
            this.workTime=workTime;
            this.latch=latch;
        }
        public void run(){
          if (workTime == 1){
              for (int i = 0; i < 10000; i++) {
                  bq.add(i);
                  System.out.println("write val = "+i);
                  try {
                      Thread.sleep(100);

                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              }
          }else{
              while (true){
                  if (bq.isEmpty()){
                      try {
                          Thread.sleep(1000);
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                      continue;
                  }
                  while (!bq.isEmpty()) {
                      Integer poll = bq.poll();
                      System.out.println("read val = " + poll);
                  }
              }
          }

        }

        private void doWork(){
            try {
                Thread.sleep(workTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
