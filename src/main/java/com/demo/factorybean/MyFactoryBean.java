/**
 * MyFactoryBean.java  
 * Created on  11/1/15 下午4:33
 * modify on                user            modify content
 * 11/1/15 下午4:33        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.factorybean;

import com.demo.proxy.jdk.BookFacade;
import org.springframework.beans.factory.FactoryBean;

import java.util.Date;

/**
 * Created by micx  on 2015/01/11 下午4:33.
 */
public class MyFactoryBean implements FactoryBean {
    private boolean flag;

    public Object getObject() throws Exception {
        if (flag) {
            return new Date();
        }
        FacadeProxy proxy = new FacadeProxy();
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class<?> clazz = classLoader.loadClass("com.demo.proxy.jdk.BookFacade");

        BookFacade bookProxy = (BookFacade) proxy.bind(clazz);
        return bookProxy;
    }

    @SuppressWarnings("unchecked")
    public Class getObjectType() {
        return flag ? Date.class : BookFacade.class;
    }

    public boolean isSingleton() {
        return false;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
