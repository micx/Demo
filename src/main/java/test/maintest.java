package test;

import config.Config;
import dpinterface.*;

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
    private static String verifyReceiptXml= Config.verifyReceiptXml;
    public static void main(String[] args) {
        DpThirdPartyInterface test = new DpThirdPartyInterface();
        //第三方向点评发起的请求测试
        System.out.println("verifyResult:\n"+test.verifyReceipt(Config.verifyReceiptXml));    //验卷测试
        System.out.println("queryResult:\n"+test.queryReceipt(Config.queryReceiptXml));    //查询测试

        //点评向第三方发起的请求测试
//        System.out.println("queryResult:\n"+test.sendReceipt(Config.sendReceiptXml));      //发卷测试
//        System.out.println("queryResult:\n"+test.refundReceipt(Config.refundReceiptXml));  //退卷测试
    }
}
