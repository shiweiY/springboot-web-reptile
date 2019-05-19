package com.reptile.boss.utils;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;

public class HttpClientUtil {
	
	private static final String ADDRESS = "https://www.zhipin.com";
	
	private static CloseableHttpClient client = HttpClients.createDefault();
	
	
	/**
	 * http get请求
	 * @param uriget
	 * @return CloseableHttpResponse response
	 * @throws Exception
	 */
	public static CloseableHttpResponse sendHttpGet(String uriget,String user_agent) throws Exception {
		URIBuilder ubuilder = new URIBuilder(ADDRESS+uriget);
		
		URI uri = ubuilder.build();
		System.out.println("请求地址:"+uri.toString());
		
		//整理请求头
		List<Header> lheader = getListHeader(uriget,user_agent);
		
		HttpGet doGet = new HttpGet(uri);
		for (Header header : lheader) {
			doGet.addHeader(header);
		}

		CloseableHttpResponse response = client.execute(doGet);
		
		return response;
	}
	
	
	/****
	 * 根据请求路径整理请求头
	 * 
	 * @param String 
	 */
	
	public static List<Header> getListHeader(String uri,String user_agent) {
		List<Header> lheader = new ArrayList<Header>();
		lheader.add(new BasicHeader(HttpHeaders.ACCEPT,"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"));
		lheader.add(new BasicHeader(HttpHeaders.ACCEPT_ENCODING,"gzip, deflate, br"));
		lheader.add(new BasicHeader(HttpHeaders.ACCEPT_LANGUAGE,"zh-CN,zh;q=0.9"));
		lheader.add(new BasicHeader(HttpHeaders.CACHE_CONTROL,"no-cache"));
		lheader.add(new BasicHeader(HttpHeaders.CONNECTION,"keep-alive"));
		lheader.add(new BasicHeader(HttpHeaders.CONTENT_TYPE,"text/html;charset=UTF-8"));
		lheader.add(new BasicHeader(HttpHeaders.SERVER,"Tengine"));
		lheader.add(new BasicHeader(":authority","www.zhipin.com"));
		lheader.add(new BasicHeader(":path",uri));
		//			lheader.add(new BasicHeader(HttpHeaders.HOST,"60.250.147.59"));
		//			lheader.add(new BasicHeader("Origin","http://60.250.147.59"));
		lheader.add(new BasicHeader(HttpHeaders.REFERER,ADDRESS+uri));
		
		lheader.add(new BasicHeader(HttpHeaders.USER_AGENT,user_agent));
		lheader.add(new BasicHeader("DNT","1"));
		
		return lheader;
	}
	
	
}

