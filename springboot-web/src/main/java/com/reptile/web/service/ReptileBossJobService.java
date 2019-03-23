package com.reptile.web.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="boss-service")
public interface ReptileBossJobService {
	
	@RequestMapping(value = "/boss/getStr",method = RequestMethod.GET)
	public String getStringData();
	
	@RequestMapping(value = "/boss/getPageJob",method = RequestMethod.POST)
	public <T> List<T> getBossPageJob(@RequestParam("condition") String condition);
	
}
