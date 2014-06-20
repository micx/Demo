package test;

import config.Config;
import dpinterface.*;
import entity.EntityTest;
import utils.DpUtils;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 测试接口：
 *      sendReceipt
 *      verifyReceipt
 *      queryReceipt
 *      refundReceipt
 *
 *      注意：测试前请先确认Config文件中配置是否正确
 *
 * Created by chenxi.chen on 2014/06/11/上午9:42.
 */
public class maintest {

    private static DpThirdPartyInterface test = new DpThirdPartyInterface();
    public static void main(String[] args) throws Exception {
//        testSendReceipt();
        testQueryReceipt();
        testVerifyReceipt();
//        testRefundReceipt();
    }

    private static void testSendReceipt() {
        // System.out.println("sendResult:\n"+test.sendReceipt(Config.sendReceiptXml));      //发卷测试
    }
    private static void testQueryReceipt() throws Exception {
        System.out.println(EntityTest.getQueryXML()+"\n queryResult:\n"+test.queryReceipt(EntityTest.getQueryXML()));    //查询测试
    }
    private static void testVerifyReceipt() throws Exception {
        System.out.println("verifyResult:\n"+test.verifyReceipt(EntityTest.getVerifyXML()));    //验卷测试
    }
    private static void testRefundReceipt() {
        //System.out.println("refundResult:\n"+test.refundReceipt(Config.refundReceiptXml));  //退卷测试
    }
}
