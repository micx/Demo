/**
 * HttpController.java
 * Created on  28/12/2015 6:30 PM
 * modify on                user            modify content
 * 28/12/2015 6:30 PM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.designpattern.adapter;

/**
 * Created by micx  on 2015/12/28 6:30 PM.
 */
public class HttpController implements Controller{
    public void doHttpHandler(){
        System.out.println("http...");
    }
}
