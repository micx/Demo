/**
 * ObjectStruture.java
 * Created on  24/12/2015 2:40 PM
 * modify on                user            modify content
 * 24/12/2015 2:40 PM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.designpattern.visit.pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by micx  on 2015/12/24 2:40 PM.
 */
class ObjectStruture {
    public static List<Element> getList(){
        List<Element> list = new ArrayList<Element>();
        Random ran = new Random();
        for(int i=0; i<10; i++){
            int a = ran.nextInt(100);
            if(a>50){
                list.add(new ConcreteElement1());
            }else{
                list.add(new ConcreteElement2());
            }
        }
        return list;
    }
}
