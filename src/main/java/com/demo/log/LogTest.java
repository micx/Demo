package com.demo.log;

import org.apache.log4j.Logger;

/**
 * Created by chenxi.chen on 2014/08/27/下午5:03.
 */
public class LogTest {
    private final static Logger log = Logger.getLogger(LogTest.class);
    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            log.info("Enter the main()....");
            log.debug("Enter the mallin()....");
            log.warn("Enter the main()....");
            log.info("Enter the main()....");
            System.out.println("this is a log4j test.");
            log.info("log end.");
        }

    }

}
