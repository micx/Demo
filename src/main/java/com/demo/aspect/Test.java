/**
 * Test.java  
 * Created on  14/2/15 下午1:26
 * modify on                user            modify content
 * 14/2/15 下午1:26        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Created by micx  on 2015/02/14 下午1:26.
 */
@Service
public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:config/spring/appcontext-core.xml");
        TestBean bean = (TestBean) ctx.getBean("test");
//        AnotherTest abean = (AnotherTest) ctx.getBean("atest");
        bean.test();
        bean.invokeTestMethod();//无法调用切面
//        abean.test();
    }
}
