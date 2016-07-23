package com.demo.order;

import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by qianhao.zhou on 8/21/14.
 */
public final class OrderCodec {
    private static final int ORDER_MAGIC_NUM = 7219;
    private OrderCodec() {
    }

    private static final Logger LOGGER = Logger.getLogger(OrderCodec.class);

    public static String encode(Date date, int orderId) {
        return encode(new SimpleDateFormat("MMdd").format(date), orderId);
    }


    public static String encode(String prefix, int number) {
        char[] numChar = (number + "").toCharArray();
        //二分换位
        numChar = reverseCharArr(numChar);
        //向左移1位,第一位不动
        char tmp = numChar[1];
        for (int i = 1; i != numChar.length - 1; i++) {
            numChar[i] = numChar[i + 1];
        }
        numChar[numChar.length - 1] = tmp;
        Integer tmpNum = Integer.parseInt(new String(numChar));
        //加上一个数字
        tmpNum += ORDER_MAGIC_NUM;
        String postfix = tmpNum.toString();
        return prefix + postfix;
    }

    public static int decode(String numStr) {
        try {
            String tmpStr = numStr.substring(4);
            Integer tmpNum = Integer.parseInt(tmpStr);
            //减上一个数字
            tmpNum -= ORDER_MAGIC_NUM;
            String postfix = tmpNum.toString();
            //向右移1位,第一位不变
            char[] numChar = postfix.toCharArray();
            char tmp = numChar[numChar.length - 1];
            for (int i = numChar.length - 1; i != 1; i--) {
                numChar[i] = numChar[i - 1];
            }
            numChar[1] = tmp;
            //二分换位
            numChar = reverseCharArr(numChar);
            return Integer.parseInt(new String(numChar));
        } catch (Exception e) {
            LOGGER.error("data invalid format:" + numStr);
            return 0;
        }
    }

    private static char[] reverseCharArr(char[] numChar) {
        //第一位不动
        for (int i = 1; 2 * i < numChar.length; i++) {
            char tmp = numChar[i];
            numChar[i] = numChar[numChar.length - i];
            numChar[numChar.length - i] = tmp;
        }
        return numChar;
    }

    public static void main(String[] args) {
//        String view = encode("0410", 1234);
//        System.out.println(view);

//        System.out.println(decode(view));

        System.out.println(decode("061716893727"));//6953659
        System.out.println(decode("061411321520"));//6953659
        System.out.println(decode("061514921621"));//6953659
    }
}
