/**
 * MapTest.java  
 * Created on  3/2/15 上午10:12
 * modify on                user            modify content
 * 3/2/15 上午10:12        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.common.map;

import com.demo.json.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by micx  on 2015/02/03 上午10:12.
 */
public class MapTest {
    public static void main(String[] args) {
        LogBean bean = new LogBean();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("activityId",1);
        map.put("shopId",2);
        map.put("dishId",3);

        bean.setMap(map);
        bean.setMsg("hello");
        try {
            String str = JsonUtils.writeToJsonString(bean);
            System.out.println(str);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
