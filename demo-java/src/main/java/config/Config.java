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
    public static String thirdPartyHost= "http://xxx.xxx.xxx";

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
                "<SequenceId>39355569</SequenceId>" +
                "<ThirdpartyId>13</ThirdpartyId>" +
                "<ThirdpartyKey>123456</ThirdpartyKey>" +
                "<DealId>6217029</DealId>" +
                "<SerialList>" +
                    "<Serial>6301216286</Serial>" +
                    "<Serial>4048614721</Serial>" +
                    "<Serial>9400020787</Serial>" +
                "</SerialList>" +
                "<OrderId>265485898</OrderId>" +
            "</VerifyReceipt>";

    /**
     * 发卷接口 xml报文 格式
     */
    public static String sendReceiptXml="<?xml version=\"1.0\" encoding=\"GBK\"?>" +
            "<SendReceipt>" +
                "<SequenceId>d_2185657o_188356773t_1398331237540</SequenceId>" +
                "<ThirdpartyId>6</ThirdpartyId>" +
                "<ThirdpartyKey>123456</ThirdpartyKey>" +
                "<DealId>1003</DealId>" +
                "<DianpingSerial>1</DianpingSerial>" +
                "<SerialCount>2</SerialCount>" +
                "<SerialList>" +
                    "<Serial>1234526743</Serial>" +
                    "<Serial>1234526343</Serial>" +
                "</SerialList>" +
                "<OrderId>100234343</OrderId>" +
                "<MobileNo>1350000000</MobileNo>" +
            "</SendReceipt>";

    /**
     * 查询接口 xml报文 格式
     */
    public static String queryReceiptXml="<?xml version=\"1.0\" encoding=\"GBK\" ?>" +
            "<QueryReceipt>" +
                "<SequenceId>39355570</SequenceId>" +
                "<ThirdpartyId>13</ThirdpartyId>" +
                "<ThirdpartyKey>123456</ThirdpartyKey>" +
                "<DealId>6217029</DealId>" +
                "<SerialList>" +
                    "<Serial>6301216286</Serial>" +
                    "<Serial>4048614721</Serial>" +
                    "<Serial>9400020787</Serial>" +
                "</SerialList>" +
                "<OrderId>265485898</OrderId>" +
            "</QueryReceipt>";

    /**
     * 退卷接口 xml报文 格式
     */
    public static String refundReceiptXml="<?xml version=\"1.0\" encoding=\"GBK\" ?>" +
            "<RefundReceipt>" +
                "<SequenceId>d_2185657o_188356773t_1398331237540</SequenceId>" +
                "<ThirdpartyId>6</ThirdpartyId>" +
                "<ThirdpartyKey>623423</ThirdpartyKey>" +
                "<DealId>1003</DealId>" +
                "<SerialList>" +
                    "<Serial>1234526743</Serial>" +
                    "<Serial>1234526343</Serial>" +
                "</SerialList>" +
                "<OrderId>100234343</OrderId>" +
            "</RefundReceipt>";

}
