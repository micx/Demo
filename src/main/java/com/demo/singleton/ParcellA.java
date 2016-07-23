/**
 * ParcellA.java
 * Created on  12/1/2016 9:57 AM
 * modify on                user            modify content
 * 12/1/2016 9:57 AM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.singleton;

/**
 * Created by micx  on 2016/01/12 9:57 AM.
 */

/**
 *
 * @author tqw
 *            本例主要学习内部类的使用
 *    Java的内部类分成两部分来讲:
 *        1:内部类
 *        2:静态内部类
 *
 */
public class ParcellA {//外部类

    private int pMember;//声明一个私有成员
    private static int pstMember;//声明一个私有静态成员
    private final int pfMember=9;//常量值
    private final static int pfsMember=0;//常量静态成员

    /**
     *
     * @author tqw
     *    -#     普通内部类可以访问外部类的所有成员和方法,
     *    -#  如何在其他的类访问此内部类呢
     *  -#  必须使用外部类的对象来创建内部类对象
     *  -#  ParcellA parcel = new ParcellA(); 见Entry.java
     *      ParcellA.Contents content = parcel.new Contents();
     */
    public class Contents{//嵌套定义一个内部类
        private int i = 11;

        public int value(){//给内部类，定义的一个方法
            System.out.println(pMember);//所有成员
            System.out.println(pstMember);
            System.out.println(pfMember);
            System.out.println(pfsMember);
            outClassMethod();//可以访问外部类的普通方法
            outClassStaticMehtod();//及静态方法
            return i;
        }
        /**
         * @see 但是若Contesnts是静态的，则可以声明静态成员和静态方法
         */
//        private static int j=0;//非静态内部类，不能声明[静态成员]
//        private static int  out(){//非静态内部类，不能声明[静态方法]
//        }

    }
    /**
     *
     * @author tqw
     *    - 定义一个嵌套内部类
     *      -# 不能访问外部内的【非静态成员】,只能访问外部类的【静态成员】。同理也不能访问外部类的非静态方法
     *      -#
     */
    public static class InnerStaticClass{
        private static int memberOfStatic;//可以定义静态成员
        private static int Out(){//可以定义静态方法
            //outClassMethod();//不能访问外部类的非静态方法
            //System.out.println(pMember);//由于ParcellA,是静态内部类，所以不能访问外部内的非静态成员
            //因为静态类，是在加载类时，就初始化了。而非静态成员，是在创建对象时才初始化，分配内存
            //因此，在静态类初始化时访问外部类的非静态成员时，非静态成员还不存在，所以不能访问
            System.out.println(pstMember);//可以访问静态成员
            System.out.println(pfsMember);//可以访问常量成员.由于final int是不可变的成员，即在程序运行中它的值不可以修改。因此
            //final成员的值，就可以在加载类时就确定下来。所以在静态内部类访问它时，它是已知的，所以就
            //可以访问
            System.out.println(pfsMember);//同上原因，所以可以访问
            outClassStaticMehtod();//可以访问静态方法
            return memberOfStatic;
        }

        public void Myout(){
            Out();
        }
    }
    /**
     *
     * @author tqw
     *
     */
    class Destination{//定义另一个内部类,注意默认访问权限为包访问权限，不能在另一个包访问
        private String label;
        Destination(String WhereTo){//内部类的构造方法
            label =WhereTo;
        }
        String ReadLabel(){//给内部类，定义的一个方法
            return label;
        }
    }


    public void outClassMethod(){
        System.out.println("outClass Non_Static Method");
    }
    public static void outClassStaticMehtod(){
        System.out.println("outClass Static Method");
    }
}
