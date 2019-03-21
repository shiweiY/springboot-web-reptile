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
	
	@Autowired
	RedisHelper redis;
	
	@GetMapping("/searchJob")
	public JSONReturn search(){
		
		
		List<Object> list = boss_service.getBossPageJob("");
		
		JSONReturn Jmodel =new JSONReturn();
		if(list != null && !list.isEmpty()) {
			Jmodel.setListData(list);
		}
		
		Jmodel.setFlag(true);
		
		redis.listSet("boss_job_data", list);
		
//		List<Object> list2 = redis.listGet("boss_job_data");
		
		return Jmodel;
	}
	
}