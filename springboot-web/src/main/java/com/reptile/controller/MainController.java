package com.reptile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reptile.service.ReptileBossJobService;

@RestController
@RequestMapping("/main")
class MainController{
	
	@Autowired
	ReptileBossJobService rbs;
	
	
	@GetMapping("/searchJob")
	public <T> List<T> search(){
		
//		Long start = System.currentTimeMillis();
		
		List<T> list = rbs.getBossPageJob("");
		
//		Long end = System.currentTimeMillis();
		
//		double time = end - start;
//		
//		System.out.println("服务响应时间: "+ time / 1000);

//		String str = rbs.getStringData();
		
		System.out.println(list);
		
		return null;
	}
	
	
	
}