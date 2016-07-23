/**
 * Color.java  
 * Created on  23/9/14 上午11:29
 * modify on                user            modify content
 * 23/9/14 上午11:29        chenxi.chen
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.enumtest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenxi.chen  on 2014/09/23 上午11:29.
 */
public class Color implements Serializable{
    private static final long serialVersionUID = -8059733569008516869L;

    public static final Color RED = new Color("red color", 0);
    public static final Color GREEN = new Color("green color", 1);
    public static final Color BLUE = new Color("blue color", 2);
    public static final Color YELLOW = new Color("yellow color", 3);

    private final String _name;
    private final int _id;

    private Color(String name, int id) {
        _name = name;
        _id = id;
    }

    public String getName() {
        return _name;
    }

    public int getId() {
        return _id;
    }

    public static List<Color> values() {
        List<Color> list = new ArrayList<Color>();
        list.add(RED);
        list.add(GREEN);
        list.add(BLUE);
        list.add(YELLOW);
        return list;
    }

    @Override
    public String toString() {
        return "Color{" +
                "_name='" + _name + '\'' +
                ", _id=" + _id +
                '}';
    }

    public static void main(String[] args) {
        List<Color> values = values();

        System.out.println(values);
    }

}

