/**
 * IOTest.java
 * Created on  10/3/2016 9:21 AM
 * modify on                user            modify content
 * 10/3/2016 9:21 AM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.jvm.directmem.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by micx  on 2016/03/10 9:21 AM.
 * -verbose:gc -Xms200M -Xmx200M -Xmn100M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxDirectMemorySize=12m
 */
public class IOTest {
    static final int BUFFER_SIZE = 1024;
    private static final long _1M = 1024 * 1024;
    private static final String FILE_PATH = "/Users/micx/Desktop/book/Effective Java中文版(第2版).pdf";
//    private static final String FILE_PATH = "/Volumes/Storage/Effective Java中文版(第2版).pdf";

    public static void main(String[] args) throws Exception {


        printDirectMem();


        withMemMap();
        withOutMemMap();
        testDirectMemOOM();
//        fullGcTest();
//        gcTest();


        printDirectMem();

    }

    private static void printDirectMem() {
        try {
            Class<?> c = Class.forName("java.nio.Bits");
            Field maxMemory = c.getDeclaredField("maxMemory");
            maxMemory.setAccessible(true);
            Field reservedMemory = c.getDeclaredField("reservedMemory");
            reservedMemory.setAccessible(true);
            System.out.println(String.format("maxMem: %s m, reservedMem: %s m", (Long) maxMemory.get(null) / _1M,
                    (Long) reservedMemory.get(null) / _1M));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 直接在 JVM堆上分配内存，所以触发了多次GC，且不会触及  Full GC，
     * 因为对象根本没机会进入老年代
     */
    private static void gcTest() {
        for (int i = 0; i < 10000; i++) {
            ByteBuffer.allocate(1024 * 100);  //100K
        }
    }

    /**
     * 直接内存是通过存储在JVM堆中的DirectByteBuffer对象来引用的，
     * 所以当众多的 DirectByteBuffer对象从新生代被送入老年代后才触发了 full gc。
     */
    private static void fullGcTest() {

        for (int i = 0; i < 20000; i++) {
            ByteBuffer.allocateDirect(1024 * 100);  //100K
        }
    }

    private static void testDirectMemOOM() {
        ByteBuffer.allocateDirect(1024 * 1024 * 100); // 100MB
    }

    private static void directMemTest() {

    }

    private static void withOutMemMap() {
        try {
            File file = new File(FILE_PATH);
            FileInputStream in = new FileInputStream(file);
            FileChannel channel = in.getChannel();
            ByteBuffer buff = ByteBuffer.allocate(BUFFER_SIZE);

            long begin = System.currentTimeMillis();
            while (channel.read(buff) != -1) {
                buff.flip();
                buff.clear();
            }
            long end = System.currentTimeMillis();
            System.out.println(String.format("normal, time is:%s ms", end - begin));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void withMemMap() {
        try {
            File file = new File(FILE_PATH);
            FileInputStream in = new FileInputStream(file);
            FileChannel channel = in.getChannel();
            MappedByteBuffer buff = channel.map(FileChannel.MapMode.READ_ONLY, 0,
                    channel.size());

            byte[] b = new byte[BUFFER_SIZE];
            int len = (int) file.length();

            long begin = System.currentTimeMillis();

            for (int offset = 0; offset < len; offset += BUFFER_SIZE) {

                if (len - offset > BUFFER_SIZE) {
                    buff.get(b);
                } else {
                    buff.get(new byte[len - offset]);
                }
            }

            long end = System.currentTimeMillis();
            System.out.println(String.format("use mem map ,time is:%s ms", end - begin));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
