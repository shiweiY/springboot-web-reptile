package com.reptile.proup.utils;

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

import com.reptile.proup.api.ServiceProviders;

public class HttpClientUtil {

	//	private static final String ADDRESS = "https://www.lagou.com";

	private static CloseableHttpClient client = HttpClients.createDefault();


	/**
	 * http get请求
	 * @param servicenam	来源服务名称
	 * @param method	请求方式 
	 * @param url	请求地址
	 * @param user_agent	浏览器代理
	 * @return CloseableHttpResponse response
	 * @throws Exception
	 */
	public static CloseableHttpResponse sendHttp(ServiceProviders servicename,String method,String url,String user_agent) throws Exception {

		List<Header> lheader = null;
		
		switch (servicename) {
			case BOSS:

			break;
			
			case TC58:
//				lheader = getTc58RequestHeader();
			break;

		}

		URIBuilder ubuilder = new URIBuilder(url);
		URI uri = ubuilder.build();
		HttpGet doGet = new HttpGet(uri);

		//		for (Header header : lheader) {
		//			doGet.addHeader(header);
		//		}

		CloseableHttpResponse response = client.execute(doGet);

		return response;
	}


	/****
	 * 根据请求路径整理请求头
	 * 
	 * @param String 
	 */

	public static List<Header> getTc58RequestHeader(String url,String user_agent) {
		List<Header> lheader = new ArrayList<Header>();

		lheader.add(new BasicHeader(":authority","www.58.com")); 
		lheader.add(new BasicHeader(":method","GET"));
		lheader.add(new BasicHeader(":path","/changecity.html"));
		lheader.add(new BasicHeader(":scheme","https"));
		lheader.add(new BasicHeader(HttpHeaders.ACCEPT,"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3"));
		lheader.add(new BasicHeader(HttpHeaders.ACCEPT_ENCODING,"gzip, deflate, br"));
		lheader.add(new BasicHeader(HttpHeaders.ACCEPT_LANGUAGE,"zh-CN,zh;q=0.9"));
		lheader.add(new BasicHeader(HttpHeaders.CACHE_CONTROL,"max-age=0"));
		lheader.add(new BasicHeader(HttpHeaders.IF_MODIFIED_SINCE,"Thu, 09 Aug 2018 06:27:25 GMT"));
		lheader.add(new BasicHeader(HttpHeaders.IF_NONE_MATCH,"W/\"22620-1533796045000\""));
		lheader.add(new BasicHeader(HttpHeaders.UPGRADE,"1"));
		lheader.add(new BasicHeader(HttpHeaders.USER_AGENT,user_agent));


		//		lheader.add(new BasicHeader(HttpHeaders.CONNECTION,"keep-alive"));
		//		lheader.add(new BasicHeader(HttpHeaders.HOST,"www.lagou.com"));
		//		lheader.add(new BasicHeader(HttpHeaders.REFERER,uri));
		//		lheader.add(new BasicHeader("Upgrade-Insecure-Requests","1"));
		//		lheader.add(new BasicHeader(HttpHeaders.SERVER,"nfs/1.0.0.2"));
		//		lheader.add(new BasicHeader(HttpHeaders.TRANSFER_ENCODING,"chunked"));

		//		lheader.add(new BasicHeader(HttpHeaders.CONTENT_TYPE,"text/html"));

		//		lheader.add(new BasicHeader(":path",uri));




		return lheader;
	}



	/***
	 * 以时间戳为条件计算出一个数值
	 * @return String
	 */
	public static String getAgentID(){
		/*以当前时间戳的最后两位为随机策略*/
		String currentTimeMillis = String.valueOf(System.currentTimeMillis());

		String agid = currentTimeMillis.substring(currentTimeMillis.length()-2, currentTimeMillis.length());

		if(Integer.parseInt(agid) > 49) {//目前只有49个不同的浏览器用户代理
			agid = String.valueOf(Integer.parseInt(agid) / 2);
		}

		return agid;
	}


}

