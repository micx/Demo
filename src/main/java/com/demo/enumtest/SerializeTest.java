/**
 * SerializeTest.java  
 * Created on  8/10/14 下午4:03
 * modify on                user            modify content
 * 8/10/14 下午4:03        chenxi.chen
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.enumtest;

import com.thoughtworks.xstream.XStream;

import java.io.*;


/**
 * Created by chenxi.chen  on 2014/10/08 下午4:03.
 */
public class SerializeTest {

    private static String file = "/Users/micx/Projects/TakeAway/micx/serializeTest";

    public void saveFile(Object obj, String file){
        try{
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.flush();
            oos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public Object restoreFile(String file){
        try{
            FileInputStream fls = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fls);

            return ois.readObject();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }



    public void serializeToXml(Object obj, String file){

        XStream xstream = new XStream();
        try {
            FileOutputStream fos = new FileOutputStream(file);
            xstream.toXML(obj,fos);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    public Object deSerializeFromXml(String file){
        XStream xs = new XStream();

        try {
            FileInputStream fis = new FileInputStream(file);
            return xs.fromXML(fis);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public void enumTest(SerializeType type){
        ColorEnum color = ColorEnum.RED;
        Object obj;
        switch (type){
            case FILE:
                saveFile(color, file);
                obj = restoreFile(file);
                System.out.println(obj);
                break;
            case XML:
                serializeToXml(color,file);
                obj = deSerializeFromXml(file);
                System.out.println(obj);
                break;
        }
    }
    public void classTest(SerializeType type){
        Color color = Color.RED;
        Object obj;
        switch (type){
            case FILE:
                saveFile(color, file);
                obj = restoreFile(file);
                System.out.println(obj);
                break;
            case XML:
                serializeToXml(color,file);
                obj = deSerializeFromXml(file);
                System.out.println(obj);
                break;
        }
    }


    public static void main(String[] args) {
        SerializeTest test = new SerializeTest();
        SerializeType type = SerializeType.XML;
        test.enumTest(type);
//        test.classTest(type);
    }
}
