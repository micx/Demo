/**
 * MyTranslator.java
 * Created on  18/1/2016 2:55 PM
 * modify on                user            modify content
 * 18/1/2016 2:55 PM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.aspect.classloader;

import com.demo.aspect.dynamicproxy.Business;
import javassist.*;

/**
 * Created by micx  on 2016/01/18 2:55 PM.
 */
public class MyTranslator implements Translator {

    public void start(ClassPool pool) throws NotFoundException, CannotCompileException {
    }

    /* *
     * 类装载到JVM前进行代码织入
     */
    public void onLoad(ClassPool pool, String classname) {
        if (!"com.demo.aspect.dynamicproxy.Business".equals(classname)) {
            return;
        }
        //通过获取类文件
        try {
            CtClass cc = pool.get(classname);
            //获得指定方法名的方法
            CtMethod m = cc.getDeclaredMethod("doSomeThing");
            //在方法执行前插入代码
            m.insertBefore("{ System.out.println(\"记录日志\"); }");
        } catch (NotFoundException e) {
        } catch (CannotCompileException e) {
        }
    }

    public static void main(String[] args) {
        Business b = new Business();
        b.doSomeThing2();
        b.doSomeThing();
    }
}