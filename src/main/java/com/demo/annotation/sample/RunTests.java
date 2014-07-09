package com.demo.annotation.sample;

/**
 * Created by chenxi.chen on 2014/06/12/下午3:44.
 */
public class RunTests {
    public static void main(String[] args) throws Exception
    {
        //处理MyTest类
        TestProcessor.process("annotation.sample.MyTest");
    }
}
