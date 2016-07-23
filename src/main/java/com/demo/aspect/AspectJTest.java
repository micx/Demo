/**
 * AspectJTest.java  
 * Created on  14/2/15 下午1:05
 * modify on                user            modify content
 * 14/2/15 下午1:05        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by micx  on 2015/02/14 下午1:05.
 */
@Aspect
public class AspectJTest {
    @Pointcut("execution(* *.test(..))")
    public void test(){
        System.out.println("execution(* *.test(..))");
    }

    @Before("test()")
    public void beforeTest(JoinPoint jp){
//        throw new RuntimeException();

        System.out.println("beforeTest " + jp.getSignature().getDeclaringTypeName());
    }

    @After("test()")
    public void afterTest(JoinPoint jp){
        System.out.println("afterTest" + jp.getSignature().getDeclaringTypeName());
    }

    @Around("test()")
    public Object aroundTest(ProceedingJoinPoint p){
        System.out.println("before1"+p.getSignature().getName());
        Object obj = null;
        try {
            obj = p.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("after1"+p.getSignature().getDeclaringTypeName());
        return obj;
    }
}
