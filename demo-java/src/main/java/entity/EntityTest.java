package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenxi.chen on 2014/06/19/下午2:04.
 */
public class EntityTest {
    public static void  main(String[] args){
        System.out.println(getSendXML());
        System.out.println(getQueryXML());
        System.out.println(getVerifyXML());
        System.out.println(getRefundXML());

    }

    public static String getQueryXML() {
        QueryReceiptXML queryReceiptXML = new QueryReceiptXML();
        queryReceiptXML.setSequenceId("d_268243o_265812940t_1403062080028");
        queryReceiptXML.setThirdPartyId("30");
        queryReceiptXML.setThirdPartyKey("20140617");
        queryReceiptXML.setDealId("00001");
        List list = new ArrayList<String>();
        list.add("201406187914");
        queryReceiptXML.setSerialList(list);
        queryReceiptXML.setOrderId("265812940");
        String ret = ObjectToXMLUtils.getXMLString(queryReceiptXML,QueryReceiptXML.class);
        return ret;
    }
    public static String getVerifyXML() {
        VerifyReceiptXML verifyReceiptXML = new VerifyReceiptXML();
        verifyReceiptXML.setSequenceId("d_268243o_265812940t_1403062080028");
        verifyReceiptXML.setThirdPartyId("30");
        verifyReceiptXML.setThirdPartyKey("20140617");
        verifyReceiptXML.setDealId("00001");
        List list = new ArrayList<String>();
        list.add("201406187914");
        verifyReceiptXML.setSerialList(list);
        verifyReceiptXML.setOrderId("265812940");
        String ret = ObjectToXMLUtils.getXMLString(verifyReceiptXML,VerifyReceiptXML.class);
        return ret;
    }
    public static String getRefundXML() {

        RefundReceiptXML refundReceiptXML = new RefundReceiptXML();
        refundReceiptXML.setSequenceId("d_268243o_265699372t_1402988400003");
        refundReceiptXML.setThirdPartyId("30");
        refundReceiptXML.setThirdPartyKey("20140617");
        refundReceiptXML.setDealId("00001");
        List list = new ArrayList<String>();
        list.add("0001");
        list.add("0002");
        refundReceiptXML.setSerialList(list);
        refundReceiptXML.setOrderId("265699372");
        String ret = ObjectToXMLUtils.getXMLString(refundReceiptXML,RefundReceiptXML.class);
        return ret;
    }

    public static String getSendXML() {
        SendReceiptXML sendReceiptXML = new SendReceiptXML();
        sendReceiptXML.setSequenceId("d_268243o_265699372t_1402988400003");
        sendReceiptXML.setThirdPartyId("30");
        sendReceiptXML.setThirdPartyKey("20140617");
        sendReceiptXML.setDealId("00001");
        sendReceiptXML.setDianpingSerial("0");
        sendReceiptXML.setSerialCount("2");
        List list = new ArrayList<String>();
        list.add("0001");
        list.add("0002");
        sendReceiptXML.setSerialList(list);
        sendReceiptXML.setOrderId("265699372");
        sendReceiptXML.setMobileNo("18901796558");

        String ret = ObjectToXMLUtils.getXMLString(sendReceiptXML,SendReceiptXML.class);
        return ret;
    }
}
