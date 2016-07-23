/**
 * jvmTes.java
 * Created on  5/1/2016 5:50 PM
 * modify on                user            modify content
 * 5/1/2016 5:50 PM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.javatips;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by micx  on 2016/01/05 5:50 PM.
 */
public class JvmTest {
    public static void main(String[] args) {
        //保持引用，防止自动垃圾回收
        List<String> list = new ArrayList<String>();

        int i = 0;

        while(true){
            //通过intern方法向常量池中手动添加常量
            list.add(String.valueOf(i++).intern());
            if (i%100000 == 0){
                System.out.println(i);
            }
        }
    }


}
