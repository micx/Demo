/**
 * SpringBean.java  
 * Created on  24/9/14 上午9:46
 * modify on                user            modify content
 * 24/9/14 上午9:46        chenxi.chen
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.springbean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chenxi.chen  on 2014/09/24 上午9:46.
 */
public class SpringBean {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] {
                        "config/spring/beancontext2.xml",
                        "config/spring/beancontext1.xml" });

        context.setAllowBeanDefinitionOverriding(false);
        context.refresh();

        BeanService bean = (BeanService) context.getBean("hello");
        BeanService bean1 = (BeanService) context.getBean("hahaha");
        BeanService bean2 = (BeanService) context.getBean("testbean");
        System.out.println(bean.getService());
        System.out.println(bean1.getService());
        System.out.println(bean2.getService());


    }

}
