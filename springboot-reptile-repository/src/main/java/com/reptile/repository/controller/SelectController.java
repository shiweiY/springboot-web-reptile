package com.reptile.repository.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reptile.repository.Mapper.SelectMapper;

@RestController
@RequestMapping("/repository/select")
public class SelectController {
	
	@Autowired
	SelectMapper sm;
	
	/***
	 * 获取热门城市
	 * @return
	 */
	@RequestMapping(value = "/getHotCity",method = RequestMethod.GET)
	public List<Object> selectHotCity() {
		
		List<Object> hotcity = sm.getHotCity();
		
		if(hotcity != null && !hotcity.isEmpty()) {
			return hotcity;
		}
		
		return null;
	}
	
}
