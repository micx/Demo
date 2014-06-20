package entity;

/**
 * Created by chenxi.chen on 2014/06/19/下午5:28.
 */
public class RequestXMLFactory {
    public static String getRequestXML(RequestType requestType,Object object){
        String ret=null;
        switch (requestType) {
            case SEND_RECEIPT:
                ret = ObjectToXMLUtils.getXMLString(object, SendReceiptXML.class);
                break;
            case QUERY_RECEIPT:
                ret = ObjectToXMLUtils.getXMLString(object, QueryReceiptXML.class);
                break;
            case VERIFY_RECEIPT:
                ret = ObjectToXMLUtils.getXMLString(object, VerifyReceiptXML.class);
                break;
            case REFUND_RECEIPT:
                ret = ObjectToXMLUtils.getXMLString(object, RefundReceiptXML.class);
                break;
        }
        return ret;
    }
}
