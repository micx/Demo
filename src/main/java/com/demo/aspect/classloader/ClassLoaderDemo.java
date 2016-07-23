/**
 * ClassLoaderDemo.java
 * Created on  18/1/2016 2:56 PM
 * modify on                user            modify content
 * 18/1/2016 2:56 PM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.aspect.classloader;

import javassist.ClassPool;
import javassist.Loader;

/**
 * Created by micx  on 2016/01/18 2:56 PM.
 */
public class ClassLoaderDemo {
    public static void main(String[] args) {
        //获取存放CtClass的容器ClassPool
        ClassPool cp = ClassPool.getDefault();
        //创建一个类加载器
        Loader cl = new Loader();
        try {
            //增加一个转换器
            cl.addTranslator(cp, new MyTranslator());
            //启动MyTranslator的main函数
            cl.run("com.demo.aspect.classloader.MyTranslator", args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
