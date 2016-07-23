/**
 * Test.java  
 * Created on  11/1/15 下午4:36
 * modify on                user            modify content
 * 11/1/15 下午4:36        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.factorybean;

import com.demo.proxy.jdk.BookFacade;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Created by micx  on 2015/01/11 下午4:36.
 */
public class Test {
    public static void main(String[] args) {
        Resource res = new ClassPathResource("config/spring/factorybean.xml");
        BeanFactory factory = new XmlBeanFactory(res);
        System.out.println(factory.getBean("factoryBeanOne").getClass());
        BookFacade bean = (BookFacade) factory.getBean("factoryBeanTwo");
        System.out.println(bean.addBook());
        System.out.println(factory.getBean("&factoryBeanTwo").getClass());

    }
}
