/**
 * B.java  
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
public class B {
    private String cityid;
    private String userName;
    private List<C> list;
    private D em;

    public List<C> getList() {
        return list;
    }

    public void setList(List<C> list) {
        this.list = list;
    }
    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

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

    @Override
    public String toString() {
        String str = "cityid:"+cityid +"\tusername:"+userName+"\tlist:"+list.toString()+"\tem:"+em;
        return str;
    }
}
