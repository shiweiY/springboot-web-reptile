package com.boss.reptile;

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
import org.apache.http.util.EntityUtils;

import com.boss.reptile.utils.IOUtil;

public class BossPage {
	
	public static void main(String[] args) {
		getDocument();
	}
	
	public static void getDocument() {
		String url = "https://www.zhipin.com/c101010100/y_4-d_206-e_103/?ka=sel-salary-4";
		try {
//			Document pagedoc = Jsoup.connect(url).get();
//			OUtil.StringBufferedOutPutFile(pagedoc.toString(), "E:\\boss2.html");

			CloseableHttpClient client = HttpClients.createDefault();

			URIBuilder ubuilder = new URIBuilder(url);

			URI uri = ubuilder.build();

			//			List<NameValuePair> lnvp = new ArrayList<NameValuePair>();
			//			lnvp.add(new BasicNameValuePair("query", "Java"));
			//			lnvp.add(new BasicNameValuePair("scity", "101010100"));
			//			lnvp.add(new BasicNameValuePair("industry", ""));
			//			lnvp.add(new BasicNameValuePair("position", ""));

			List<Header> lheader = new ArrayList<Header>();
			lheader.add(new BasicHeader(HttpHeaders.ACCEPT,"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"));
			lheader.add(new BasicHeader(HttpHeaders.ACCEPT_ENCODING,"gzip, deflate, br"));
			lheader.add(new BasicHeader(HttpHeaders.ACCEPT_LANGUAGE,"zh-CN,zh;q=0.9"));
			lheader.add(new BasicHeader(HttpHeaders.CACHE_CONTROL,"no-cache"));
			lheader.add(new BasicHeader(HttpHeaders.CONNECTION,"keep-alive"));
			lheader.add(new BasicHeader(HttpHeaders.CONTENT_TYPE,"text/html;charset=UTF-8"));
			lheader.add(new BasicHeader(HttpHeaders.SERVER,"Tengine"));
			lheader.add(new BasicHeader(":authority","www.zhipin.com"));
			lheader.add(new BasicHeader(":path","/c101010100/y_4-d_206-e_103/?ka=sel-salary-4"));
			//			lheader.add(new BasicHeader(HttpHeaders.HOST,"60.250.147.59"));
			//			lheader.add(new BasicHeader("Origin","http://60.250.147.59"));
			lheader.add(new BasicHeader(HttpHeaders.REFERER,url));
			lheader.add(new BasicHeader(HttpHeaders.USER_AGENT,"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36"));
			lheader.add(new BasicHeader("DNT","1"));


			//			HttpPost doPost = new HttpPost(uri);
			//			for (Header header : lheader) {
			//				doPost.addHeader(header);
			//			}
			//			
			//			doPost.setEntity(new UrlEncodedFormEntity(lnvp,"utf-8"));

			HttpGet doGet = new HttpGet(uri);
			for (Header header : lheader) {
				doGet.addHeader(header);
			}

			CloseableHttpResponse response = client.execute(doGet);
			//请求成功
			if(response.getStatusLine().getStatusCode() == 200) {
				String RESULT = EntityUtils.toString(response.getEntity(),"UTF-8");
				
				IOUtil.StringBufferedOutPutFile(RESULT, "E:\\boss.html");
				System.out.println("end !");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
