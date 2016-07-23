/**
 * UserAddressTest.java
 * Created on  27/3/2016 10:43 AM
 * modify on                user            modify content
 * 27/3/2016 10:43 AM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.ibatis;

import ch.hsr.geohash.GeoHash;
import com.demo.ibatis.dao.UserDao;
import com.demo.ibatis.model.UserAddress;
import com.demo.thread.ThreadPoolImpl;
import com.google.common.collect.Lists;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by micx  on 2016/03/27 10:43 AM.
 */
public class UserAddressTest {
    private static UserDao userDao = UserDao.getInstance();
    private static AtomicInteger totalCost = new AtomicInteger();
    private static AtomicInteger totalQueryCnt = new AtomicInteger();
    private static AtomicInteger totalResult = new AtomicInteger();
    public static void main(String[] args) throws IOException, SQLException {

        Random random = new Random();
        double lat = 31;
        double lng = 121;
        CountDownLatch latch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            long t = System.currentTimeMillis();
            List<String> list = Lists.newArrayListWithCapacity(1000);
            for (int j = 0; j <1000; j++) {
                GeoHash gh = GeoHash.withBitPrecision(lat+random.nextDouble(), lng+random.nextDouble(), 29);
                String geoHash = gh.toBinaryString();
                list.add(geoHash);
            }
            InternalTask task = new InternalTask(list, latch);
            ThreadPoolImpl.submit(task);
            System.out.println(String.format("generate task[%s] cost:%s ms", i, System.currentTimeMillis() - t));

        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("QPS:%s, totalQueryCnt:%s, totalCost:%s, avgCost:%s, totalResultCnt:%s",
                totalQueryCnt.get()*1000/totalCost.get(), totalQueryCnt.get(),totalCost.get(), totalCost.get()/totalQueryCnt.get(), totalResult ));
    }

    private static class InternalTask implements Runnable{

        private List<String> geoHashList;
        private CountDownLatch latch;

        public InternalTask(List<String> geoHashList, CountDownLatch latch) {
            this.geoHashList = geoHashList;
            this.latch = latch;
        }

        public void run() {
            try {
                long t = System.currentTimeMillis();
                long resultCnt = 0;
                for (String geoHash: geoHashList) {
                    try {
                        List<UserAddress> addressList = userDao.getUserAddress(geoHash);
                        resultCnt+=addressList.size();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                int size = geoHashList.size();
                totalQueryCnt.getAndAdd(size);
                long cost = System.currentTimeMillis() - t;
                totalCost.getAndAdd((int) cost);
                totalResult.getAndAdd((int) resultCnt);
                System.out.println(String.format("query:%s times, avg:%s ms, cost:%s ms, resultCnt:%s", size, cost/size, cost, resultCnt));
            } finally {
                latch.countDown();
                System.out.println(latch.getCount());
            }
        }
    }

}
