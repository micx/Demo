package sozhe;

import org.json.JSONException;
import org.json.JSONObject;
import utils.HttpRequest;
import utils.HttpTookit;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenxi.chen on 2014/06/13/下午2:13.
 */
public class SoZheTest {
    private static String url = "http://www.sozhe.com/api/website_api.php";

    enum METHOD{ADDORDER,SELECTORDER,RESENDORDER,RESENDCHANGE,CANCELORDER};
    public static void main(String[] args) throws IOException, JSONException {

        String getAddParam = getParam(METHOD.ADDORDER);
        String getSelectParam = getParam(METHOD.SELECTORDER);
        String getCancelParam = getParam(METHOD.CANCELORDER);

        Map postAddParam = postParam(METHOD.ADDORDER);
        Map postSelectParam  = postParam(METHOD.SELECTORDER);
        Map postCancelParam = postParam(METHOD.CANCELORDER);

        System.out.println(url+"?"+getAddParam);
        System.out.println(url+"?"+getSelectParam);
        System.out.println(url+"?"+getCancelParam);
        String retAdd = HttpTookit.doGet(url,getAddParam,"utf8",true);
        String retSelect = HttpRequest.sendGet(url,getSelectParam);
//        String retCancel = HttpTookit.doGet(url,getCancelParam,"utf8",true);
        String ret = HttpRequest.sendPost(url, getSelectParam);
        String ret1 = HttpRequest.postHttpRequest(url+"?"+getSelectParam,"POST","utf8",2000,null);



        System.out.println("addorder return: "+retAdd);
        System.out.println("selectorder return: "+retSelect);
//        System.out.println("cancekorder return: "+retCancel);
        System.out.println("post select order return: "+ret);
        System.out.println("post ret1: "+ret1);
        ret1=ret1.substring(1);
        ret1 = ret1.trim();

        retAdd = retAdd.substring(1);
        JSONObject jsonObject = new JSONObject(retAdd);
        System.out.println(jsonObject.get("code")+"\n"+jsonObject.get("message")+"\n"+jsonObject.getJSONObject("body").get("order_id"));
    }
    private static String getParam(METHOD method) throws UnsupportedEncodingException {
        String account = "account=test&secret=test123";//&ask=addorder&body="+URLEncoder.encode(body.toString(),"utf8");
        String ask = "&ask=";
        String body = "&body=";
        switch (method){
           case ADDORDER:
               ask+="addorder";
               body+=getAddOrderBody();
               break;
           case SELECTORDER:
               ask+="selectorder";
               body+=getSelectOrderBody();
               break;
           case CANCELORDER:
               ask+="cancelorder";
               body+=getCancelOrderBody();
               break;
           default:
        }
        return account+ask+body;
    }
    private static Map postParam(METHOD method) throws UnsupportedEncodingException {
        Map param = new HashMap();
        param.put("account","test");
        param.put("secret","test123");
        switch (method){
            case ADDORDER:
                param.put("ask", "addorder");
                param.put("body", getAddOrderBody());
                break;
            case SELECTORDER:
                param.put("ask", "selectorder");
                param.put("body",getSelectOrderBody());
                break;
            case CANCELORDER:
                param.put("ask","cancelorder");
                param.put("body",getCancelOrderBody());
                break;
            default:
        }
        return param;
    }

    private static String getAddOrderBody() throws UnsupportedEncodingException {
        Map map = new HashMap();
        map.put( "team_id", 79);
        map.put( "mobile", "15811012123");
        map.put( "amount", 3);
        map.put( "trade_no","79disnaiadnq125");
        JSONObject jsonObject = new JSONObject(map);
        System.out.println( jsonObject );
        return URLEncoder.encode(jsonObject.toString(),"utf8");
    }

    private static String getSelectOrderBody() throws UnsupportedEncodingException {
        Map map = new HashMap();
        map.put( "order_id", 84459);
        JSONObject jsonObject = new JSONObject(map);
        System.out.println( jsonObject );
         return  URLEncoder.encode(URLEncoder.encode(jsonObject.toString(),"utf8"),"utf8");
        //     return  URLEncoder.encode(jsonObject.toString(),"utf8");
    }

    private static String getCancelOrderBody() throws UnsupportedEncodingException {
        Map map = new HashMap();
        map.put( "order_id", 84441);
        map.put( "cancel_num", 1);
        JSONObject jsonObject = new JSONObject(map);
        System.out.println( jsonObject );
        return URLEncoder.encode(jsonObject.toString(),"utf8");
    }
}
