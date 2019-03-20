package com.reptile.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reptile.cache.service.RedisHelper;
import com.reptile.web.service.ReptileBossJobService;

@RestController
@RequestMapping("/main")
class MainController{
	
	@Autowired
	ReptileBossJobService rbs;
	
	@Autowired
	RedisHelper redis;
	
	@GetMapping("/searchJob")
	public String search(){
		
//		Long start = System.currentTimeMillis();
		
		List<Job> list = rbs.getBossPageJob("");
		
//		Long end = System.currentTimeMillis();
		
//		double time = end - start;
//		
//		System.out.println("服务响应时间: "+ time / 1000);

//		String str = rbs.getStringData();
		
//		System.out.println(list);
		
		redis.listSet("bossjoblist", list);
		
		System.out.println(redis.listGet("joblist"));
		
		return "ok";
	}
	
}