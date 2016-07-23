/**
 * Client.java
 * Created on  24/12/2015 2:40 PM
 * modify on                user            modify content
 * 24/12/2015 2:40 PM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.designpattern.visit.pattern;

import java.util.List;

/**
 * Created by micx  on 2015/12/24 2:40 PM.
 * http://blog.csdn.net/zhengzhb/article/details/7496949
 */
public class Client {
    public static void main(String[] args){
        List<Element> list = ObjectStruture.getList();
        for(Element e: list){
            e.accept(new Visitor());
        }
    }
}
