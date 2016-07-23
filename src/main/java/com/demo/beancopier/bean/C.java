/**
 * C.java  
 * Created on  203/9/14 下午5:04
 * modify on                user            modify content
 * 203/9/14 下午5:04        chenxi.chen
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.beancopier.bean;

/**
 * Created by chenxi.chen  on 2014/09/03 下午5:04.
 */
public class C {
    private String name;
    private String age;

    public C(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    @Override
    public String toString() {
        String str = "name:"+name +"\tage:"+age;
        return str;
    }
}
