package chinamobile;

import config.Config;
import dpinterface.DpThirdPartyInterface;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by chenxi.chen on 2014/06/18/下午4:53.
 */
public class ChinaMobileTest {
        private static String verifyReceiptXml= Config.verifyReceiptXml;
        public static void main(String[] args) throws Exception {

//        System.out.println(DpUtils.buildMD5Sign(Config.verifyReceiptXml));

            DpThirdPartyInterface test = new DpThirdPartyInterface();
            //第三方向点评发起的请求测试
            //System.out.println("verifyResult:\n"+test.verifyReceipt(Config.verifyReceiptXml));    //验卷测试
            System.out.println("queryResult:\n"+test.queryReceipt(Config.queryReceiptXml));    //查询测试

            //点评向第三方发起的请求测试
            // System.out.println("sendResult:\n"+test.sendReceipt(Config.sendReceiptXml));      //发卷测试
            System.out.println("refundResult:\n"+test.refundReceipt(Config.refundReceiptXml));  //退卷测试
        }
}
