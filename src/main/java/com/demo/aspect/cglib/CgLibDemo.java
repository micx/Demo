/**
 * CgLibDemo.java
 * Created on  18/1/2016 10:13 AM
 * modify on                user            modify content
 * 18/1/2016 10:13 AM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.aspect.cglib;

import com.demo.aspect.dynamicproxy.Business;
import com.demo.aspect.dynamicproxy.iface.IBusiness2;
import net.sf.cglib.proxy.Enhancer;

/**
 * Created by micx  on 2016/01/18 10:13 AM.
 */
public class CgLibDemo {
    public static void main(String[] args) {
        byteCodeGe();
    }

    public static void byteCodeGe() {
        //创建一个织入器
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(Business.class);
        //设置需要织入的逻辑
        enhancer.setCallback(new LogIntercept());
        //使用织入器创建子类
        IBusiness2 newBusiness = (IBusiness2) enhancer.create();
        newBusiness.doSomeThing2();
    }

}
