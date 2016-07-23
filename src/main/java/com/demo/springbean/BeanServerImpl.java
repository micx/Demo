/**
 * BeanServer.java  
 * Created on  24/9/14 上午9:58
 * modify on                user            modify content
 * 24/9/14 上午9:58        chenxi.chen
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.springbean;

import org.springframework.stereotype.Service;

/**
 * Created by chenxi.chen  on 2014/09/24 上午9:58.
 */
@Service
public class BeanServerImpl implements BeanService {
    @Override
    public String getService() {
        return "BeanServer";
    }
}
