/**
 * ToJson.java  
 * Created on  5/12/14 上午11:22
 * modify on                user            modify content
 * 5/12/14 上午11:22        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.json.json;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by micx  on 2014/12/05 上午11:22.
 */
public class ToJson {
    static ObjectMapper mapper = new ObjectMapper();
    public static void main(String[] args) {
        User user = new User();
        user.setPassword("1234");
        user.setEmail("micx@163.com");
        B b = new B();
        b.setId("123");
        user.setB(b);
        User[] users = new User[] { user };
        try {
            String str = mapper.writeValueAsString(users);
            try {
                String jsonStr = mapper.writeValueAsString(user);
                System.out.println(jsonStr);
                User readValue = mapper.readValue(jsonStr, User.class);
                System.out.println("read value:"+readValue);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(str);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
