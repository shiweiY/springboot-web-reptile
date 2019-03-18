package com.reptile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.reptile.service.ReptileBossJobService;

@RestController
@RequestMapping("/main")
class MainController{
	
	@Autowired
	ReptileBossJobService rbs;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/searchJob")
	public <T> List<T> search(){
		
//		List<T> list = rbs.getBossPageJob("");
		String list = this.restTemplate.getForObject("http://boss-reptile-server//main/searchJob", String.class).toString();
		
		return null;
	}
	
	
	
}