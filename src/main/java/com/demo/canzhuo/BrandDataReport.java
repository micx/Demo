package com.demo.canzhuo;

import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qianhao.zhou on 9/15/14.
 */
public class BrandDataReport {

    private HttpClient httpClient;
    private Map<String, Integer> brandMap = new HashMap<String, Integer>();
    private Map<Integer, String> storeMap = new HashMap<Integer, String>();
    private Map<Integer,List<Integer>> brand2StoreMap = new HashMap<Integer, List<Integer>>();

    BrandDataReport() {
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
        connManager.setMaxTotal(1000);
        connManager.setDefaultMaxPerRoute(1000);
        SocketConfig socketConfig = SocketConfig.custom()
                .setTcpNoDelay(true)
                .setSoKeepAlive(true)
                .setSoReuseAddress(true)
                .setSoTimeout(1000*60) //socket读写的超时时间
                .build();
        connManager.setDefaultSocketConfig(socketConfig);
        ConnectionConfig connectionConfig = ConnectionConfig.custom()
                .setCharset(Consts.UTF_8)
                .build();
        connManager.setDefaultConnectionConfig(connectionConfig);
        httpClient = HttpClients.custom()
                .setConnectionManager(connManager)
                .build();



        BasicCookieStore cookieStore = new BasicCookieStore();
        BasicClientCookie session = new BasicClientCookie("PHPSESSID", "01thhreq6n4a7sju15oqt940e1");
        session.setDomain("admin.canzhuowang.cn");
        session.setPath("/");
        cookieStore.addCookie(session);
//        httpClient.(cookieStore);
    }

    private void getPhpSessionId() throws Exception {
        System.out.println(request("http://www.canzhuowang.cn/member/ajaxOldUser"));
    }

    private String request(String url) throws IOException {
        httpClient.getParams().setParameter("http.protocol.cookie-policy", CookiePolicy.BROWSER_COMPATIBILITY);

        System.out.println("sending request...");
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        httpGet.addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.120 Safari/537.36");
        httpGet.addHeader("Accept-Encoding:", "gzip,deflate,sdch");
        httpGet.addHeader("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6,ja;q=0.4,zh-TW;q=0.2");

        HttpResponse response = httpClient.execute(httpGet);
        System.out.println("response code:" + response.getStatusLine().getStatusCode());
//        System.out.println("response headers:");
//        for (Header header: response.getAllHeaders()) {
//            System.out.println(header);
//        }
        String result = EntityUtils.toString(new GzipDecompressingEntity(response.getEntity()), "utf-8");
        return result;
    }


    private void showAdminPage() throws IOException {
        String result = request("http://admin.canzhuowang.cn/admin.php");
        System.out.println(result);
    }

    private void showMembers() throws Exception {
        handleBrandID();
        handleStoreID();
        System.out.println(brand2StoreMap.size());
        requestDays();
        requestMonths();

    }

    private void requestMonths() throws IOException, InterruptedException {
        for(Integer brandId: brand2StoreMap.keySet()) {
            for(Integer storeId: brand2StoreMap.get(brandId)) {
                File file = new File("/Users/micx/Projects/canzhuo/month/" + storeId);
                FileWriter fw = new FileWriter(file);
                fw.write(request("http://admin.canzhuowang.cn/admin.php/brandreport/months?brand_id=" + brandId + "&store_id=" + storeId));
                Thread.sleep(10);
                fw.close();
            }
        }
    }

    private void requestDays() throws InterruptedException, IOException {
        for(Integer brandId: brand2StoreMap.keySet()) {
            for(Integer storeId: brand2StoreMap.get(brandId)) {
                File file = new File("/Users/micx/Projects/canzhuo/days/" + storeId);
                FileWriter fw = new FileWriter(file);
                fw.write(request("http://admin.canzhuowang.cn/admin.php/brandreport/days?brand_id=" + brandId + "&store_id=" + storeId));
                Thread.sleep(10);
                fw.close();
            }
        }
    }

    private void handleStoreID() throws IOException {
        FileReader reader = new FileReader("/Users/micx/Projects/canzhuo/store_id_name");
        BufferedReader br = new BufferedReader(reader);

        int cnt = 0;
        String str ;
        while((str = br.readLine()) != null) {
            ++cnt;
            String[] arr = str.split("\\|");
            int id = Integer.parseInt(arr[0]);
            String name = arr[1].split("（")[0];
            storeMap.put(id,arr[1]);
            Integer brandId = brandMap.get(name);
            if(brandId != null){
                List<Integer> list = brand2StoreMap.get(brandId);
                if(list == null){
                    list = new ArrayList<Integer>();
                }
                list.add(id);
                brand2StoreMap.put(brandId, list);
            }else{
                System.out.println("not found\t"+id+"\t"+name);
            }
        }
        System.out.println(cnt);
        reader.close();
    }

    private void handleBrandID() throws IOException {
        FileReader reader = new FileReader("/Users/micx/Projects/canzhuo/brand_id_name");
        BufferedReader br = new BufferedReader(reader);

        int cnt = 0;
        String str ;
        while((str = br.readLine()) != null) {
            ++cnt;
            String[] arr = str.split("\\|");
            int id = Integer.parseInt(arr[0]);
            String name = arr[1].split("（")[0];
            brandMap.put(name, id);
        }
        System.out.println(cnt);
        reader.close();

    }

    public static void main(String[] args) throws Exception {
        BrandDataReport store = new BrandDataReport();
        store.showMembers();

    }
}
