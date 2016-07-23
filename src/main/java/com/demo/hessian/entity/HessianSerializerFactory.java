/**
 * HessianSerializerFactory.java  
 * Created on  9/5/15 9:25 AM
 * modify on                user            modify content
 * 9/5/15 9:25 AM        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.hessian.entity;

import com.caucho.hessian.io.*;

import java.math.BigInteger;
import java.util.HashMap;

/**
 * Created by micx  on 2015/05/09 9:25 AM.
 */
public class HessianSerializerFactory extends SerializerFactory {

    private static HashMap serializerMap = new HashMap();
    private static HashMap deserializerMap = new HashMap();

    static {
        serializerMap.put(BigInteger.class, new StringValueSerializer());
        try {
            deserializerMap.put(BigInteger.class, new StringValueDeserializer(BigInteger.class));
        } catch (Throwable e) {
        }
    }

    public Serializer getSerializer(Class cl) throws HessianProtocolException {
        Serializer serializer = (Serializer) serializerMap.get(cl);
        if (serializer != null)
            return serializer;
        return super.getSerializer(cl);
    }

    public Deserializer getDeserializer(Class cl) throws HessianProtocolException {
        Deserializer deserializer = (Deserializer) deserializerMap.get(cl);
        if (deserializer != null)
            return deserializer;
        return super.getDeserializer(cl);
    }
}
