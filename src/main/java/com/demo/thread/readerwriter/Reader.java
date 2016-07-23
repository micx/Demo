/**
 * Reader.java  
 * Created on  3/3/15 上午9:45
 * modify on                user            modify content
 * 3/3/15 上午9:45        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.thread.readerwriter;

/**
 * Created by micx  on 2015/03/03 上午9:45.
 */
class Reader implements Runnable
{
    private Buffer buffer;
    public Reader(Buffer buffer)
    {
        this. buffer=buffer;
    }
    public void run()
    {
        while(true) //表示 读者不停在进行读操作
        {
            synchronized(buffer)
            {
                while(!buffer.flag) {
                    try {
                        buffer.wait();
                    } catch (Exception ex) {

                    }
                }
                for(int i=0;i<buffer.i;i++)
                {
                    System.out.print(buffer.buffer[i]);
                }
                System.out.println();
                buffer.flag=false;
                buffer.notifyAll();

            }
            try {
                Thread.sleep(100);
            }catch(Exception ex) {

            }  //这句话没有什么意思,只是为了让输出会慢一点,在这个程序里面没有其他作用,加不加都一个样
        }
    }
}
