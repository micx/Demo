/**
 * Test.java
 * Created on  31/12/2015 2:29 PM
 * modify on                user            modify content
 * 31/12/2015 2:29 PM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.trycatch;

/**
 * Created by micx  on 2015/12/31 2:29 PM.
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(new Test().test());
        int x = new Test().test1();
        System.out.println(x);
        int t2 = test2();
        System.out.println(t2);

    }
    static B test() {
        B b = new B();
        int x = 1;
        try {
            b.setX(1);
            b.setY(2);
            x++;
            return b;
        }catch (Exception e){
            return b;
        } finally {
//            return 4;
            b.setX(23);
            x++;
            b = new B();
        }
//        return b;
    }
    static int test1() {
        int x = 1;
        try {

            x++;
            return x;
        }catch (Exception e){
            return x;
        } finally {
//            return 4;
            x++;
            System.out.println(x);
            return x;
        }
    }

    public static int test2() {
        int i = 1;

//  if(i == 1)
//   return 0;
        System.out.println("the previous statement of try block");
        i = i / 0;

        try {
            System.out.println("try block");
            return i;
        }finally {
            System.out.println("finally block");
        }
    }

}
