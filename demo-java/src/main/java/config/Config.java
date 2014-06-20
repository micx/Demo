package config;

/**
 * Created by chenxi.chen on 2014/06/11/下午2:28.
 */
public class Config {

    /**
     *  查询、验证   HOST
     *  环境  host
     *  测试环境    180.166.152.82:5680
     *  生产环境    180.153.132.83
     * 点评提供服务host
     */
    public static String dpHost= "180.166.152.82:5680";      //测试环境
    //public static String dpHost= "180.153.132.83";         //生产环境

    /**
     * 第三方填入服务host
     */
    public static String thirdPartyHost= "www.34v.com/masmanage/service/sendreceipt.aspx";
    public static String thirdPart1yHost= "www.34v.com/masmanage/service/RefundReceipt.aspx";

    /**
     *  密钥
     *  环境  md5key
     *  测试环境    d61b2a012014b9b5648579d406b190b4
     *  生产环境    具体对接时提供
     */
    public static String md5Key = "d61b2a012014b9b5648579d406b190b4";

    /**
     * 验卷接口 xml报文 格式
     */
    public static String verifyReceiptXml="<?xml version=\"1.0\" encoding=\"GBK\"?>" +
            "<VerifyReceipt>" +
                "<SequenceId>3935556939355569</SequenceId>" +
                "<ThirdpartyId>27</ThirdpartyId>" +
                "<ThirdpartyKey>123456</ThirdpartyKey>" +
                "<DealId>599350_174832</DealId>" +
                "<SerialList>" +
                    "<Serial>2016936178930</Serial>" +
                "</SerialList>" +
                "<OrderId>265885575</OrderId>" +
            "</VerifyReceipt>";

    /**
     * 发卷接口 xml报文 格式
     */
    public static String sendReceiptXml = "<SendReceipt xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">" +
            "  <SequenceId>d_268243o_265699372t_1402988400003</SequenceId>" +
            "  <ThirdpartyId>30</ThirdpartyId>" +
            "  <ThirdpartyKey>20140617</ThirdpartyKey>" +
            "  <DealId>00001</DealId>" +
            "  <DianpingSerial>0</DianpingSerial>" +
            "  <SerialCount>2</SerialCount>" +
            "  <SerialList />" +
            "  <OrderId>265699372</OrderId>" +
            "  <MobileNo>18901796558</MobileNo>" +
            "</SendReceipt>";
//    public static String sendReceiptXml="<?xml version=\"1.0\" encoding=\"GBK\"?>" +
//            "<SendReceipt>" +
//                "<SequenceId>d_2185657o_188356773t_1398331237540</SequenceId>" +
//                "<ThirdpartyId>30</ThirdpartyId>" +
//                "<ThirdpartyKey>20140617</ThirdpartyKey>" +
//                "<DealId>1003</DealId>" +
//                "<DianpingSerial>1</DianpingSerial>" +
//                "<SerialCount>2</SerialCount>" +
//                "<SerialList>" +
//                    "<Serial>1234526743</Serial>" +
//                    "<Serial>1234526343</Serial>" +
//                "</SerialList>" +
//                "<OrderId>100234343</OrderId>" +
//                "<MobileNo>1350000000</MobileNo>" +
//            "</SendReceipt>";

    /**
     * 查询接口 xml报文 格式
     */
//    public static String queryReceiptXml="<?xml version=\"1.0\" encoding=\"GBK\" ?>" +
//            "<QueryReceipt>" +
//                "<SequenceId>39355570</SequenceId>" +
//                "<ThirdpartyId>30</ThirdpartyId>" +
//                "<ThirdpartyKey>20140617</ThirdpartyKey>" +
//                "<DealId>00001</DealId>" +
//                "<SerialList>" +
//                "</SerialList>" +
//                "<OrderId>265699372</OrderId>" +
//            "</QueryReceipt>";
    public static String queryReceiptXml="<?xml version=\"1.0\" encoding=\"GBK\"?>" +
            "<QueryReceipt>" +
            "<SequenceId>d_268243o_265812940t_1403062080028</SequenceId>" +
            "<ThirdpartyId>30</ThirdpartyId>" +
            "<ThirdpartyKey>20140617</ThirdpartyKey>" +
            "<DealId>00001</DealId>" +
            "<SerialList>" +
            "<Serial>201406187914</Serial>" +
            "</SerialList>" +
            "<OrderId>265812940</OrderId>" +
            "</QueryReceipt>";

    /**
     * 退卷接口 xml报文 格式
     */
    public static String refundReceiptXml="<?xml version=\"1.0\" encoding=\"GBK\" ?>" +
            "<RefundReceipt>" +
                "<SequenceId>d_268243o_265812940t_1403062080028</SequenceId>" +
                "<ThirdpartyId>30</ThirdpartyId>" +
                "<ThirdpartyKey>20140617</ThirdpartyKey>" +
                "<DealId>00001</DealId>" +
                "<SerialList>" +
                    "<Serial>201406185810</Serial>" +
                "</SerialList>" +
                "<OrderId>265699372</OrderId>" +
            "</RefundReceipt>";

}
