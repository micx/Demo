/**
 * ReflectTest.java  
 * Created on  8/12/14 下午6:38
 * modify on                user            modify content
 * 8/12/14 下午6:38        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by micx  on 2014/12/08 下午6:38.
 */
public class ReflectTest {

    public String test(){
        return "reflect test...";
    }

    public int add(Integer x, Integer y){
        return x+y;
    }
    public static void main(String[] args)
    {
        try {
            Method method = ReflectTest.class.getMethod("add",new Class[]{Class.forName("java.lang.Integer"),Class.forName("java.lang.Integer")});
            Integer sum = (Integer) method.invoke(new ReflectTest(),1,2);

            method = ReflectTest.class.getMethod("test");
            System.out.println(sum);
            System.out.println(method.invoke(new ReflectTest()));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
