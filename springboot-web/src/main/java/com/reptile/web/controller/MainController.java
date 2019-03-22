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
		
		
		List<Object> list = boss_service.getBossPageJob("");
		
		JSONReturn Jmodel =new JSONReturn();
		if(list != null && !list.isEmpty()) {
			Jmodel.setListData(list);
			RedisHelper.setSerialData("boss_job_data", list);
			Jmodel.setFlag(true);
		}else {
			Jmodel.setFlag(false);
			Jmodel.setMessage("Boss 直聘,职位数据爬去失败");
		}
		
		
		List<Object> list2 = (List<Object>) RedisHelper.getSerialData("boss_job_data");
		
		return Jmodel;
	}
	
}