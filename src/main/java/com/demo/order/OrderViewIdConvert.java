/**
 * OrderViewIdConvert.java  
 * Created on  13/4/15 2:46 PM
 * modify on                user            modify content
 * 13/4/15 2:46 PM        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.order;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Arrays;
import java.util.List;

/**
 * Created by micx  on 2015/04/13 2:46 PM.
 */
public class OrderViewIdConvert {
    private int x;
    private int y;
    private int z;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderViewIdConvert)) return false;

        OrderViewIdConvert that = (OrderViewIdConvert) o;

        if (x != that.x) return false;
        if (y != that.y) return false;
        if (z != that.z) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + z;
        return result;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }

    public static void main(String[] args) {
        List<String> listadd = Arrays.asList("04057005570");
        for (String str : listadd) {
            int decode = OrderCodec.decode(str);
            System.out.println(decode);
        }
    }
}
