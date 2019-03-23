package com.reptile.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.reptile.cache.service.RedisHelper;
import com.reptile.web.model.JSONReturn;
import com.reptile.web.service.ReptileBossJobService;

@RestController
@RequestMapping("/main")
class MainController{
	
	@Autowired
	ReptileBossJobService boss_service;
	
	//不再使用springboot 集成的redis
//	@Autowired
//	RedisHelper redis;
	
	@GetMapping("/searchJob")
	public JSONReturn search(){
		
		long start = System.currentTimeMillis();
		
		List<Object> list = boss_service.getBossPageJob("/c101010100/y_4-d_206-e_103/?ka=sel-salary-4");
		
		JSONReturn Jmodel =new JSONReturn();
		if(list != null && !list.isEmpty()) {
			
			Map<String,Object> resultMap = new HashMap<>();
			resultMap.put("list", list);
			Jmodel.setMapData(resultMap);
			RedisHelper.setSerialData("boss_job_data", list);
			Jmodel.setFlag(true);
		}else {
			Jmodel.setFlag(false);
			Jmodel.setMessage("Boss 直聘,职位数据爬去失败");
		}
		long end = System.currentTimeMillis();
		
		long num = end - start;
		double sum = num / 1000d;
		
		Jmodel.setMessage("后端爬取及处理时间："+sum);
//		List<Object> list2 = (List<Object>) RedisHelper.getSerialData("boss_job_data");
		
		return Jmodel;
	}
	
}