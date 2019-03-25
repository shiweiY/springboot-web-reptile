package com.reptile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.reptile.cache.service.RedisHelper;
import com.reptile.web.service.RepositoryService;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class WebMainApplication implements ApplicationRunner {
	
	@Autowired
	RepositoryService rs;

	public static void main(String[] args) {
		SpringApplication.run(WebMainApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println(1);
		System.out.println(2);
		
		List<Object> hotcity = rs.getHotCity();
		
		System.out.println(3);
		System.out.println(4);
		System.out.println(5);
		
		RedisHelper.setSerialData("mainPage_hotcity", hotcity);
	}
	
}
