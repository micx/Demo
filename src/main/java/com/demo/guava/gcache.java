/**
 * gcache.java
 * Created on  11/4/2016 3:28 PM
 * modify on                user            modify content
 * 11/4/2016 3:28 PM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by micx  on 2016/04/11 3:28 PM.
 */
public class gcache {

    private static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) {
        LoadingCache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        return loadValue(key);
                    }
                });
        try {
            String value = cache.get("micx");
            String value1 = cache.get("adam");
            String value2 = cache.get("guang");
            String value3 = cache.get("micx");
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    private static String loadValue(String key) {
        return key + atomicInteger.incrementAndGet() ;
    }
}
