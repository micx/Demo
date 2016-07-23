/**
 * Business.java
 * Created on  18/1/2016 9:49 AM
 * modify on                user            modify content
 * 18/1/2016 9:49 AM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.aspect.dynamicproxy;

import com.demo.aspect.dynamicproxy.iface.IBusiness;
import com.demo.aspect.dynamicproxy.iface.IBusiness2;

/**
 * Created by micx  on 2016/01/18 9:49 AM.
 */
public class Business implements IBusiness, IBusiness2 {

    public boolean doSomeThing() {
        System.out.println("执行业务逻辑");
        return true;
    }

    public boolean doSomeThing2() {
        System.out.println("执行业务逻辑2");
        return false;
    }

}
