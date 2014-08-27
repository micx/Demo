package com.demo.utils;

import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by chenxi.chen on 2014/07/09/下午5:53.
 */
public class UtilsDemo {
    public static int hash16(String name) {
        int i = name.hashCode();
        i = (0xFFFF & i) ^ (i >>> 16);
        return i;
    }
    public static void pattern(String[] args){
        String pattern = "{0}, hello! you get ${1} at {2}.";
        Object[] params = {"John",1.3E4,new GregorianCalendar().getTime()};
        String msg = MessageFormat.format(pattern,params);
        System.out.println(msg);
    }
    public static void main(String[] args){
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
        Date date = null;
        try {
            date = (new SimpleDateFormat("yyyy-MM-dd")).parse("2014-01-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar sCalendar = Calendar.getInstance();
        sCalendar.setTime(date);
        String startStr = sdf.format(sCalendar.getTime());
        sCalendar.add(Calendar.DATE,-7);
        String endStr = sdf.format(sCalendar.getTime());

        System.out.println(startStr+endStr+"\n"+sCalendar.getActualMinimum(Calendar.DATE)+"\t"+sCalendar.getActualMaximum(Calendar.DATE));


        int year = 2014;
        int month = 8;

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,year);
        cal.set(Calendar.MONTH,Calendar.AUGUST);
        cal.set(Calendar.DATE,cal.getActualMinimum(Calendar.DATE));
        cal.set(Calendar.HOUR,-12);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND,0);
        System.out.println(cal.getTime().toString());

        cal.set(Calendar.MONTH,Calendar.AUGUST);
        cal.set(Calendar.DATE,cal.getActualMaximum(Calendar.DATE));
        cal.set(Calendar.HOUR,23);
        cal.set(Calendar.MINUTE,59);
        cal.set(Calendar.SECOND,59);
        System.out.println(cal.getTime().toString());




        cal.setTime(new Date());
        cal.set(Calendar.HOUR_OF_DAY,11);
        System.out.println(cal.getTime().toString());
        cal.set(Calendar.HOUR_OF_DAY,20);
        System.out.println(cal.getTime().toString());
        cal.set(Calendar.HOUR,20);
        System.out.println(cal.getTime().toString());


        Integer count = 0;
        plus(count);
        System.out.println(count);



//        String[] test = {
//                "TakeAwayDishInfo", //0x48ee
//                "MinAmount",    //0x1ed7
//                "PromoText",     //0xc57c
//                "DishSetList"     //0x179a
//        };
//        String[] str = {
//                "MinFeeText",
//                "DeliveryFee",
//                "ArrivedInterval",
//                "Activity",
//                "ShopPower",
//                "ReviewStr",
//                "ReviewCount",
//                "IsShowReviewed",
//
//                "HotNum",
//                "BigImageUrl",
//                "DishIntroduction",
//
//                "TAActivity",
//                "ActivityButton",
//                "ActivityInfo",
//                "LastPayType",
//                "PayPromo",
//                "MaxArrivedTime",
//                "Time",
//                "SpanTime",
//                "OpeningTimeTip",
//                "OrderViewId"
//        };
//        System.out.println("test hashcode:");
//        for(String s:test){
//            System.out.println(s+":\t0x"+Integer.toHexString(hash16(s)));
//        }
//
//        System.out.println("6.8 new segment hashcode:");
//        for(String s:str){
//            s=s.substring(0,1).toUpperCase() + s.substring(1);
//            System.out.println(s+":\t0x"+Integer.toHexString(hash16(s)));
//        }
    }

    private static void plus(Integer count) {
        ++count;
    }
}
