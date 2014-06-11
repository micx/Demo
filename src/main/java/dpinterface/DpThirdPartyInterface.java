package dpinterface;

import config.Config;
import utils.DpUtils;
import utils.HttpTookit;

/**
 * Created by chenxi.chen on 2014/06/11/下午2:16.
 */
public class DpThirdPartyInterface {
    /**
     * 说明：序列号发送接口。大众点评发起请求，对接方按规定格式返回。
     * 请求类型：GET
     * 合作方地址：http://host/sendreceipt?xml=xxx&sign=xxx
     * 参数说明：sign为验签参数，xml为提交报文。
     * @return String
     */
    public String sendReceipt(String xml){
        String param = "xml="+xml+"&"+"sign="+ DpUtils.buildMD5Sign(xml);
        String url = "http://"+Config.thirdPartyHost+"/sendreceipt?";
        String ret = HttpTookit.doGet(url, param, "GBK", true);
        return ret;
    }

    /**
     * 说明：序列号查询接口。三方系统可向大众点评发起查询序列号状态请求，点评按规定格式返回。查询接口不需要流水号。
     * 大众点评地址：http://host/thirdparty/queryreceipt?xml=xxx&sign=xxx
     * 参数说明：sign为验签参数，xml为提交报文。
     * @return String
     */
    public String queryReceipt(String xml){
        String param = "xml="+xml+"&"+"sign="+DpUtils.buildMD5Sign(xml);
        String url = "http://"+Config.dpHost+"/thirdparty/queryreceipt?";
        String ret = HttpTookit.doGet(url, param, "GBK", true);
        return ret;
    }

    /**
     * 说明：序列号验证接口。三方系统在用户使用券后，实时向大众点评发起请求，点评按规定格式返回。
     * 大众点评地址：http://host/thirdparty/verifyreceipt?xml=xxx&sign=xxx
     * 参数说明：sign为验签参数，xml为提交报文。
     * @return String
     */
    public String verifyReceipt(String xml){
        String param = "xml="+xml+"&"+"sign="+DpUtils.buildMD5Sign(xml);
        String url = "http://"+Config.dpHost+"/thirdparty/verifyreceipt?";
        String ret = HttpTookit.doGet(url, param, "GBK", true);
        return ret;
    }

    /**
     * 接口说明：序列号退券接口，由点评通知合作方将券置为已退券状态，对接方按规定格式返回。
     * 请求类型：GET
     * 合作方地址：http://host/refundreceipt?xml=xxx&sign=xxx
     * 参数说明：sign为验签参数，xml为提交报文。
     * @return String
     */
    public String refundReceipt(String xml){
        String param = "xml="+xml+"&"+"sign="+DpUtils.buildMD5Sign(xml);
        String url = "http://"+Config.thirdPartyHost+"/refundreceipt?";
        String ret = HttpTookit.doGet(url, param, "GBK", true);
        return ret;
    }
}
