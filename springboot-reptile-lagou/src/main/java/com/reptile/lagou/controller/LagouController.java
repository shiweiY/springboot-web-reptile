package com.reptile.lagou.controller;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reptile.lagou.model.Job;
import com.reptile.lagou.service.LagouPageService;
import com.reptile.lagou.utils.HttpClientUtil;
import com.reptile.lagou.utils.IOUtil;

@RestController
@RequestMapping("/lagou")
public class LagouController {
	private static final Logger LOG = LoggerFactory.getLogger(LagouController.class);
	
	@Autowired
	LagouPageService lgservice;
	
	@PostMapping("/getLagouJob")
	public List<Job> getLagouPageJob(@RequestParam("url") String url){
		
		url="/list_?labelWords=&fromSearch=true&suginput=";
		
//		Document doc = (Document) Jsoup.connect("https://www.lagou.com/"+url).get();
		
		
		//获取用户代理，浏览器标识，以防止被网站屏蔽ip或者要求验证码
		String user_agent = HttpClientUtil.getAgentID();
		LOG.info("获取的浏览器用户代理为: " + user_agent);
		
		//发送http get请求获取资源
		try {
			CloseableHttpResponse response = HttpClientUtil.sendHttpGet(url,user_agent);
			
			if(response.getStatusLine().getStatusCode() == 200){
				String results = EntityUtils.toString(response.getEntity(),"UTF-8");
				
				if(results == null || results.isEmpty()){
					LOG.warn("GET 获取页面信息为空！ ："+url);
				}else{
					IOUtil.StringBufferedOutPutFile(results, "E:\\lagou.html");
					//业务层爬去页面职位数据
					List<Job> jobList = lgservice.getJobList(results);
					
					return jobList;
				}
				
			}else{
				LOG.warn("GET请求页面时失败！ 错误代码 ："+response.getStatusLine().getStatusCode());
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("发起请求获取页面信息时出现错误: "+e);
		}
		
		return null;
	}
}
