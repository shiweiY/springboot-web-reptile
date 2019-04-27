package com.reptile.web.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="tc58-service")
public interface FeignTc58Service {

	@RequestMapping(value = "/tc58/getTc58Job",method = RequestMethod.POST)
	public <T> List<T> get58TcPageJob(@RequestParam("url") String url);
}
