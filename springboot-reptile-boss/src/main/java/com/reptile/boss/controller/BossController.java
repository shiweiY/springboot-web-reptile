package com.reptile.boss.controller;

import java.util.List;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reptile.boss.model.Job;
import com.reptile.boss.service.BossPageService;
import com.reptile.boss.utils.HttpClientUtil;
import com.reptile.boss.utils.IOUtil;


@RestController()
@RequestMapping(value = "/boss")
public class BossController {
	private static final Logger log = LoggerFactory.getLogger(BossController.class);
	
	@Autowired
	BossPageService pageService;
	
	@GetMapping("/getStr")
	public String getStringData() {
		
		return "hello spring";
	}
	
	@PostMapping("/getPageJob")
	public List<Job> getJobPage(String url) {
		
		String result = "";
		
		//假设路径
		url = "/c101010100/y_4-d_206-e_103/?ka=sel-salary-4";
		
		List<Job> jobList = null;
		
		try {
			
			CloseableHttpResponse response = HttpClientUtil.sendHttpGet(url);
			
//			请求成功
			if(response.getStatusLine().getStatusCode() == 200) {
				
				result = EntityUtils.toString(response.getEntity(),"UTF-8");
				
				if(result == null || result.isEmpty()) {
					log.warn("GET 获取页面信息为空！ ："+url);
				}
				
				IOUtil.StringBufferedOutPutFile(result, "E:\\boss.html");
				
				//业务层爬去页面职位数据
				jobList = pageService.getJobList(result);
				
			}else {
				log.warn("GET 请求页面时失败！ 错误代码 ："+response.getStatusLine().getStatusCode());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("发起请求获取页面信息时出现错误: "+e);
		}
		return jobList;
	}
}
