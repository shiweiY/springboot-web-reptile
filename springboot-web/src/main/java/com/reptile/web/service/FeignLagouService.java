package com.reptile.web.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="lagou-service")
public interface FeignLagouService {
	
	@PostMapping("/lagou/getLagouJob")
	public <T> List<T> getLagouPageJob(@RequestParam("url") String url);
}
