package com.reptile.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "boss-reptile-server")
public interface ReptileBossJobService {
	
	@RequestMapping(value = "/boss/getPageJob",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public <T> List<T> getBossPageJob(String condition);
	
}
