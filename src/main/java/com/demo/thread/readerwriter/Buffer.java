/**
 * Buffer.java  
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
public class Buffer {
    public  int  buffer[]=new int [10];//用于标识共享的缓冲区
    public  boolean flag=false;//用于标识缓冲区的状态
    public  int   i;//表示向缓冲区写的位置
}
