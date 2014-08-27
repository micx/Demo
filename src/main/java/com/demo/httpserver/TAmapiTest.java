package com.demo.httpserver;

import org.json.JSONObject;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenxi.chen on 2014/07/24/下午12:08.
 */
public class TAmapiTest {
    private String ip;
    private String address;
    public void  init() throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        ip=addr.getHostAddress().toString();//获得本机IP
        address=addr.getHostName().toString();//获得本机名称
    }
    public void DishListTest() throws Exception {
        String localUrl = "http://yimin.dp/http://"+ip+":8080/ta-order/dishlist.ta";
        String betaUrl  = "http://yimin.dp/http://waimai.order.51ping.com/dishlist.ta";
        // TODO Auto-generated method stub
        Map<String, String> params = new HashMap<String, String>();
        params.put("shopid", "10007938");
        params.put("lng", "121.4159884701903");
        params.put("lat", "31.217850628195");
        params.put("source", "1");
        params.put("address", "安化路508号");
        params.put("cityid", "1");

        HttpServer server = new HttpServer();
        server.init();
        String res = server.get(betaUrl, params);
        JSONObject jsonObject = new JSONObject(res);
        System.out.println(res);
    }
    public static void main(String[] args) throws Exception {
        TAmapiTest tAmapiTest = new TAmapiTest();
        tAmapiTest.init();
        tAmapiTest.DishListTest();

    }
}
