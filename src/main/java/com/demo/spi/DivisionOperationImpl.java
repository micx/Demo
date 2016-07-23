/**
 * DivisionOperationImpl.java
 * Created on  17/2/2016 4:24 PM
 * modify on                user            modify content
 * 17/2/2016 4:24 PM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.spi;

/**
 * Created by micx  on 2016/02/17 4:24 PM.
 */
public class DivisionOperationImpl implements IOperation {

    public int operation(int numberA, int numberB) {
        printInfo();
        return numberA / numberB;
    }
    public void printInfo(){
        System.out.println(String.format("%s - %s",this.getClass().getName(),
                this.getClass().getClassLoader()));
    }
}