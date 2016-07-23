/**
 * JsonUtils.java  
 * Created on  3/2/15 上午10:23
 * modify on                user            modify content
 * 3/2/15 上午10:23        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by micx  on 2015/02/03 上午10:23.
 */
public class JsonUtils {
    private static final ObjectMapper mapper = new ObjectMapper();
    public static Object readValue(String ruleJson, Class clazz) throws IOException {
        return mapper.readValue(ruleJson, clazz);
    }

    public static String writeToJsonString(Object obj) throws JsonProcessingException {
        return mapper.writeValueAsString(obj);
    }
}
