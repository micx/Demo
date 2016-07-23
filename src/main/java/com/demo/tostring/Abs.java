/**
 * Abs.java  
 * Created on  8/1/15 上午11:32
 * modify on                user            modify content
 * 8/1/15 上午11:32        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.tostring;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Created by micx  on 2015/01/08 上午11:32.
 */
public class Abs {
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this,
                ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
