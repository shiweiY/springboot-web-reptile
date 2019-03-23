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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reptile.boss.model.Job;
import com.reptile.boss.repository.Boss2DBMapper;
import com.reptile.boss.service.Boss2DBService;
import com.reptile.boss.service.BossPageService;
import com.reptile.boss.utils.HttpClientUtil;
import com.reptile.boss.utils.IOUtil;


@RestController
@RequestMapping(value = "/boss")
public class BossController {
	private static final Logger log = LoggerFactory.getLogger(BossController.class);
	
	@Autowired
	BossPageService pageService;
	
	/*@Autowired
	Boss2DBService dbService;*/
	
	@Autowired 
	Boss2DBMapper bossmapper;
	
	@GetMapping("/getStr")
	public String getStringData() {
		
		return "hello spring";
	}
	
	@PostMapping("/getPageJob")
	public List<Job> getJobPage(@RequestParam("condition") String url) {
		
		String result = "";
		
		//假设路径
//		url = "/c101010100/y_4-d_206-e_103/?ka=sel-salary-4";
		
		List<Job> jobList = null;
		
		try {
			
			/*以当前时间戳的最后两位为随机策略*/
			String currentTimeMillis = String.valueOf(System.currentTimeMillis());
			
			String agid = currentTimeMillis.substring(currentTimeMillis.length()-2, currentTimeMillis.length());
			
			if(Integer.parseInt(agid) > 49) {//目前只有49个不同的浏览器用户代理
				agid = String.valueOf(Integer.parseInt(agid) / 2);
			}
			
			//获取用户代理，浏览器标识，以防止被网站屏蔽ip或者要求验证码
			String user_agent = bossmapper.getBrowserUserAgent(agid);
			log.info("获取的浏览器用户代理为: " + user_agent);
			
			//发送http get请求获取资源
			CloseableHttpResponse response = HttpClientUtil.sendHttpGet(url,user_agent);
			
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
				log.warn("GET请求页面时失败！ 错误代码 ："+response.getStatusLine().getStatusCode());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("发起请求获取页面信息时出现错误: "+e);
		}
		return jobList;
	}
}
