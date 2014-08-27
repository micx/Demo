package com.demo.httpserver;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.io.*;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.util.*;

/**
 * Created by qianhao.zhou on 6/15/14.
 */
public class HttpServer {


	private HttpClient httpClient;

	private static final int DEFAULT_SOCKET_TIME_OUT = 5000;

	private static final int DEFAULT_CONNECTION_TIME_OUT = 1000;

	private static final int MAX_CONNECTIONS = 20;

	@PostConstruct
	public void init() {
		HttpParams params = new BasicHttpParams();
		params.setParameter(CoreConnectionPNames.SO_TIMEOUT, DEFAULT_SOCKET_TIME_OUT);
		params.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, DEFAULT_CONNECTION_TIME_OUT);
		ConnManagerParams.setMaxTotalConnections(params, MAX_CONNECTIONS);
		ConnManagerParams.setTimeout(params, DEFAULT_SOCKET_TIME_OUT);
		ConnManagerParams.setMaxConnectionsPerRoute(params, new ConnPerRouteBean(MAX_CONNECTIONS));

		SchemeRegistry schemeRegistry = new SchemeRegistry();
		schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));

		ThreadSafeClientConnManager connectionManager = new ThreadSafeClientConnManager(params, schemeRegistry);

		this.httpClient = new DefaultHttpClient(connectionManager, params);
	}

	public String get(String url, Map<String, String> parameters) throws Exception {
		if (parameters != null && !parameters.isEmpty()) {
			StringBuilder query = new StringBuilder();
			for (Map.Entry<String, String> entry : parameters.entrySet()) {
				query.append(entry.getKey()).append("=").append(entry.getValue());
				query.append("&");
			}
			url += "?" + query.substring(0, query.length() - 1);
		}
		HttpGet httpGet = new HttpGet(url);
		try {
			HttpResponse httpResponse = httpClient.execute(httpGet);
			final int statusCode = httpResponse.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_OK) {
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				httpResponse.getEntity().writeTo(baos);
				return new String(baos.toByteArray());
			} else {
				throw new Exception("invalid http status code:" + statusCode);
			}
		} catch (IOException e) {
			throw new Exception(e);
		}
	}

	/**
	 * Post提交请求
	 * @param url
	 * @param parameters
	 * @return
	 * @throws Exception
	 */
	public String post(String url, Map<String, String> parameters) throws Exception {
        Reader reader = null;
        try {
			HttpPost post = new HttpPost(url);

			post.setEntity(getHttpEntity(parameters));

			HttpResponse httpResponse = httpClient.execute(post);
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				reader = new InputStreamReader(httpResponse.getEntity().getContent());
				BufferedReader bufferedReader = new BufferedReader(reader);
				StringBuilder result = new StringBuilder();
				String line = null;
				while ((line = bufferedReader.readLine()) != null) {
					result.append(line + " ");
				}

				return result.toString();
			} else {
				throw new Exception("invalid http status code:" + httpResponse.getStatusLine().getStatusCode());
			}
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			try {
				if (reader != null) reader.close();
			} catch (IOException e) {

			}
		}
	}

	private static HttpEntity getHttpEntity(Map<String, String> parameters) throws IOException, UnsupportedEncodingException {
		List<NameValuePair> params = new ArrayList<NameValuePair>();

		Iterator<Map.Entry<String, String>> it = parameters.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
			String key = (String) entry.getKey();
			String value = entry.getValue();
			if (value != null) {
				params.add(new BasicNameValuePair(key, value));
			}
		}
		return new UrlEncodedFormEntity(params, "UTF-8");
	}


}
