/**
 * A.java  
 * Created on  22/3/15 上午9:47
 * modify on                user            modify content
 * 22/3/15 上午9:47        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.clone.entity;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by micx  on 2015/03/22 上午9:47.
 */
public class A {
    private int x;
    private int y;
    private String tx;


    @Override
    public int hashCode() {
        int h = x;
        h = 31 * h + y;
        if (StringUtils.isNotBlank(tx)) {
            h = 31 * h + tx.hashCode();
        }
        return h;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof A){
            A tmp = (A) obj;
            return  tmp.hashCode() ==  this.hashCode() && tmp.getX() == this.x
                    && tmp.getY() == this.y && StringUtils.equals(tmp.getTx(), this.tx);
        }
        return false;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getTx() {
        return tx;
    }

    public void setTx(String tx) {
        this.tx = tx;
    }

    @Override
    public String toString() {
        return "A{" +
                "x=" + x +
                ", y=" + y +
                ", tx='" + tx + '\'' +
                '}';
    }
}
