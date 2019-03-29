package com.reptile.repository.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reptile.repository.Mapper.BossRepositoryMapper;

@RestController
@RequestMapping("/repository/boss/select")
public class BossRepositorySelect {
	
	@Autowired
	BossRepositoryMapper brmapper;
	
	/***
	 * 获取热门城市
	 * @return
	 */
	@RequestMapping(value = "/getHotCity",method = RequestMethod.GET)
	public List<Object> selectHotCity() {
		
		List<Object> hotcity = brmapper.getHotCity();
		
		if(hotcity != null && !hotcity.isEmpty()) {
			return hotcity;
		}
		
		return null;
	}
	
	/***
	 * 获取城市path
	 * @param cityname
	 * @return city_path
	 */
	@RequestMapping(value = "/getBossCityPath",method = RequestMethod.GET)
	public String selectBossCityPath(@RequestParam("cityname") String cityname){
		return brmapper.selectBossCityPath(cityname);
	}
	
	/***
	 * 获取工作经验path
	 * @param exp
	 * @return exp_path
	 */
	@RequestMapping(value = "/getBossExpPath",method = RequestMethod.GET)
	public String selectBossExpPath(@RequestParam("exp") String exp){
		return brmapper.selectBossExpPath(exp);
	}
	
	
}
