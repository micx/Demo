/**
 * HessianTest.java  
 * Created on  8/5/15 11:45 AM
 * modify on                user            modify content
 * 8/5/15 11:45 AM        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.hessian;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.HessianOutput;
import com.demo.hessian.entity.Data;
import com.demo.hessian.entity.HessianSerializerFactory;
import com.google.common.collect.Maps;
import org.apache.commons.lang.ArrayUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * Created by micx  on 2015/05/08 11:45 AM.
 */
public class HessianTest {

    private static HessianSerializerFactory sessianSerializerFactory = new HessianSerializerFactory();

    public static byte[] serialize(Object obj) throws IOException {
        if(obj==null) throw new NullPointerException();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        HessianOutput h2o = new HessianOutput(os);
        h2o.setSerializerFactory(sessianSerializerFactory);
        h2o.writeObject(obj);
        return os.toByteArray();
    }

    public static Object deserialize(byte[] by) throws IOException{
        if(by==null) throw new NullPointerException();
        ByteArrayInputStream is = new ByteArrayInputStream(by);
        Hessian2Input h2in = new Hessian2Input(is);
        h2in.setSerializerFactory(sessianSerializerFactory);
        return h2in.readObject();
    }

    public static void main(String[] args) throws IOException {

        Map<Integer, Data> map = Maps.newHashMap();

        Data data1 = new Data();
        Data data2 = new Data();
//        Timestamp t = new Timestamp(System.currentTimeMillis());
        Date t = new Date();
        String[] stringArray1 = ArrayUtils.EMPTY_STRING_ARRAY;
        String[] stringArray2 = ArrayUtils.EMPTY_STRING_ARRAY;
        data1.setStringArr(stringArray1);
        data2.setStringArr(stringArray2);

        /** 1 2  失败
         *  1 成功
         *  2 失败
         */
        data1.setTimestamp(t);// 1
        data2.setTimestamp(t);// 2

        map.put(1, data1);
        map.put(2, data2);

        byte[] bytes = serialize(map);
        deserialize(bytes);
    }



}
