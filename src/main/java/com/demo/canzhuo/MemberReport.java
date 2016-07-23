package com.demo.canzhuo;

import org.apache.http.HttpResponse;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.util.EntityUtils;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by qianhao.zhou on 9/15/14.
 */
public class MemberReport {

    private DefaultHttpClient httpClient;

    MemberReport() {
        httpClient = new DefaultHttpClient();
        BasicCookieStore cookieStore = new BasicCookieStore();
        BasicClientCookie session = new BasicClientCookie("PHPSESSID", "hi41acnuf9fj49sbc2vrjrcd06");
        session.setDomain("admin.canzhuowang.cn");
        session.setPath("/");
        cookieStore.addCookie(session);
        httpClient.setCookieStore(cookieStore);
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
        FileWriter fw = new FileWriter("/Users/micx/Projects/canzhuo/member-1");
        for(int i=7629; i<=7790; ++i) {
            fw.write(request("http://admin.canzhuowang.cn/admin.php/member/admin?Member_page="+i));
            System.out.println("page="+i);
            Thread.sleep(10);
        }
        fw.close();
    }

    public static void main(String[] args) throws Exception {
        MemberReport hacker = new MemberReport();
        hacker.showMembers();

    }
}
