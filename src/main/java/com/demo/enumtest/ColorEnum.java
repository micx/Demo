/**
 * ColorEnum.java  
 * Created on  8/10/14 下午4:29
 * modify on                user            modify content
 * 8/10/14 下午4:29        chenxi.chen
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.enumtest;

/**
 * Created by chenxi.chen  on 2014/10/08 下午4:29.
 */
public enum ColorEnum {

    RED("red color", 0),
    GREEN("green color", 1),
    BLUE("blue color", 2),
    YELLOW("yellow color", 3);

    public final String name;
    public final int id;

    ColorEnum(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ColorEnum{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
