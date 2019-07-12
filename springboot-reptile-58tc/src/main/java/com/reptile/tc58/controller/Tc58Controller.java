package com.reptile.tc58.controller;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reptile.tc58.model.Job;
import com.reptile.tc58.service.Tc58PageService;
import com.reptile.tc58.utils.HttpClientUtil;
import com.reptile.tc58.utils.IOUtil;


@RestController
@RequestMapping("/tc58")
public class Tc58Controller {
	private static final Logger LOG = LoggerFactory.getLogger(Tc58Controller.class);
	private static final ExecutorService THREADPOOL = Executors.newCachedThreadPool();

	@Autowired
	Tc58PageService tcservice;

	@PostMapping("/getTc58Job")
	public List<Job> getLagouPageJob(@RequestParam("url") String url){

//		url="https://bj.58.com/job/";

		//		Document doc = (Document) Jsoup.connect("https://www.lagou.com/"+url).get();

		long start = System.currentTimeMillis();

		//获取用户代理，浏览器标识，以防止被网站屏蔽ip或者要求验证码
		String user_agent = HttpClientUtil.getAgentID();
		LOG.info("获取的浏览器用户代理为: " + user_agent);

		//发送http get请求获取资源
		try {
			CloseableHttpResponse response = HttpClientUtil.sendHttpGet(url,user_agent);

			if(response.getStatusLine().getStatusCode() == 200){
				String results = EntityUtils.toString(response.getEntity(),"UTF-8")+url;

				//				System.out.println(results);

				if(results == null || results.isEmpty()){
					LOG.warn("GET 获取页面信息为空！ ："+url);
				}else{
					
					THREADPOOL.execute(new Runnable() {
						@Override
						public void run() {
							IOUtil.StringBufferedOutPutFile(Jsoup.parse(results).toString(), "E:\\58tc.html");
						}
					});
					
					//业务层解析页面职位数据
					List<Job> jobList = tcservice.getJobList(results);

					long end = System.currentTimeMillis();

					LOG.info("本次58同城后端处理时间: "+(end-start)+" ms");

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
