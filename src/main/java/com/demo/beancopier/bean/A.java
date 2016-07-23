/**
 * A.java  
 * Created on  203/9/14 下午3:25
 * modify on                user            modify content
 * 203/9/14 下午3:25        chenxi.chen
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.beancopier.bean;

import java.util.List;

/**
 * Created by chenxi.chen  on 2014/09/03 下午3:25.
 */
public class A {
    private int x;
//    private String cityId;
    private String userName;
    private List<C> list;
    private D em;

    public List<C> getList() {
        return list;
    }

    public void setList(List<C> list) {
        this.list = list;
    }

//    public String getCityId() {
//        return cityId;
//    }
//
//    public void setCityId(String cityId) {
//        this.cityId = cityId;
//    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public D getEm() {
        return em;
    }

    public void setEm(D em) {
        this.em = em;
    }
}
