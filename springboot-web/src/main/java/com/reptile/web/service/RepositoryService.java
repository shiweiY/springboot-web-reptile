package com.reptile.web.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="repository-service")
public interface RepositoryService {
	
	//获取热门城市信息
	@RequestMapping(value = "/repository/select/getHotCity",method = RequestMethod.GET)
	public List<Object> getHotCity();
}
