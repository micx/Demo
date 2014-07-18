package com.demo.utils;

import java.text.MessageFormat;
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
        String[] test = {
                "TakeAwayDishInfo", //0x48ee
                "MinAmount",    //0x1ed7
                "PromoText",     //0xc57c
                "DishSetList"     //0x179a
        };
        String[] str = {
                "MinFeeText",
                "DeliveryFee",
                "ArrivedInterval",
                "Activity",
                "ShopPower",
                "ReviewStr",
                "ReviewCount",
                "IsShowReviewed",

                "HotNum",
                "BigImageUrl",
                "DishIntroduction",

                "TAActivity",
                "ActivityButton",
                "ActivityInfo",
                "LastPayType",
                "PayPromo"
        };
        System.out.println("test hashcode:");
        for(String s:test){
            System.out.println(s+":\t0x"+Integer.toHexString(hash16(s)));
        }

        System.out.println("6.8 new segment hashcode:");
        for(String s:str){
            System.out.println(s+":\t0x"+Integer.toHexString(hash16(s)));
        }
    }
}
