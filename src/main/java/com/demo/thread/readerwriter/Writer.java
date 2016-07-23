/**
 * Writer.java  
 * Created on  3/3/15 上午9:42
 * modify on                user            modify content
 * 3/3/15 上午9:42        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.thread.readerwriter;

/**
 * Created by micx  on 2015/03/03 上午9:42.
 */

//可能会有多个读
class Writer implements Runnable {
    private Buffer buffer;

    public Writer(Buffer buffer) {
        this.buffer=buffer;
    }
    public void run() {
        //用循环表示不停地向里面写东西
        while(true) {
            //这里面是同步代码块,里面都是对共享数据的操作,只能有一个线程操作
            synchronized(buffer) {
                //如果共享数据flag=true,表示共享数据块里面已经写入数据还没有被读出来,如果再写的话,就要等待，这也是控制读一次写一次的关键
                while(buffer.flag) {
                    try {
                        buffer.wait();
                    } catch (Exception ex) {

                    }
                }
                buffer.buffer[buffer.i]=buffer.i;//这里面是向缓冲区里面写入数据的操作
                buffer.i=((buffer.i+1)%buffer.buffer.length);//防止数据的溢出
                buffer.flag=true;
                buffer.notifyAll();
            }
            try {
                Thread.sleep(100);
            }catch(Exception ex) {

            }
        }
    }
}
