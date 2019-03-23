package com.reptile.cache.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.reptile.web.model.JSONReturn;



@RestController
@RequestMapping(value = "/TransientData")
public class TransientForPage {
	
	@RequestMapping(value="/getRedisDataByKeys",method=RequestMethod.POST)
	public JSONReturn getTransientData(HttpServletRequest request) {
		Map<Object,Object> map = new HashMap<Object,Object>();
		String[] keys = request.getParameterValues("params");
		
		for (String key : keys) {
			if(key.indexOf(".") == -1) {
				map.put(key, RedisHelper.getString(key));
			}else {
				String[] keySplit = key.split("\\.");
				map.put(key, RedisHelper.getSerialData(keySplit[0]));
			}
		}
		
		JSONReturn jr = new JSONReturn();
		jr.setFlag(true);
		jr.setMapData(map);
		
		return jr;
	}
	
	@RequestMapping(value="/getSerialData",method=RequestMethod.POST)
	public JSONReturn getSerialData(HttpServletRequest request) {
		JSONReturn jr = new JSONReturn();
		String key = request.getParameter("params");
		
		if(key != null && !key.isEmpty()) {
			Object obj = RedisHelper.getSerialData(key);
			
			Map<Object,Object> map = new HashMap<Object,Object>();
			map.put(key, obj);
			
			jr.setMapData(map);
		}
		
		jr.setFlag(true);
		
		return jr;
	}
	
	
	
	
}
