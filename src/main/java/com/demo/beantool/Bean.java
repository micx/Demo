/**
 * Bean.java  
 * Created on  19/11/14 上午11:55
 * modify on                user            modify content
 * 19/11/14 上午11:55        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.beantool;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Created by micx  on 2014/11/19 上午11:55.
 */
public class Bean extends A{
    private int id;
    private String name;
    private int age;

    public Bean() {
    }

    public Bean(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this,
                ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public static void main(String[] args) {
        Bean bean = new Bean(1,"micx",26);
        System.out.println(bean);
    }
}
