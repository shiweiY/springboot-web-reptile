package com.reptile.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.reptile.web.mapper.Main2RepositoryMapper;
import com.reptile.web.service.RepositoryService;
import com.reptile.web.tech.cache.service.RedisHelper;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class WebMainApplication implements ApplicationRunner {
	
	@Autowired
	Main2RepositoryMapper brmapper;

	public static void main(String[] args) {
		SpringApplication.run(WebMainApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		List<Object> hotcity = brmapper.getHotCity();
		
		RedisHelper.setSerialData("mainPage_hotcity", hotcity);
	}
	
}
