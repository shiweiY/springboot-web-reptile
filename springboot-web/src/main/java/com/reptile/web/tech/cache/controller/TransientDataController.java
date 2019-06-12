package com.reptile.web.tech.cache.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reptile.web.model.JSONReturn;
import com.reptile.web.tech.cache.service.RedisHelper;

@RestController
@RequestMapping("/web/TransientData")
public class TransientDataController {
	
//	@Autowired
//	RedisHelper redis;
	
	@GetMapping(value = "/getSerialData")
	public JSONReturn getSerialData(@RequestParam("rediskey") String rediskey) {
		JSONReturn Jmodel =new JSONReturn();
		
		Object obj = RedisHelper.getSerialData(rediskey);
		
		Map<String,Object> resultMap = new HashMap<>();
		resultMap.put("result", obj);
		Jmodel.setMapData(resultMap);
		Jmodel.setFlag(true);
		
		return Jmodel;
	}
}
