package com.reptile.web.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="repository-service")
public interface RepositoryService {

	//查询某表某个值
	@RequestMapping(value = "/repository/select/selectTableValue",method = RequestMethod.GET)
	public String selectTableValue(@RequestParam("table")String table,@RequestParam("value")String value,@RequestParam("sqlcondition")String sqlcondition);

	//获取热门城市信息
	@RequestMapping(value = "/repository/boss/select/getHotCity",method = RequestMethod.GET)
	public List<Object> getHotCity();

	//Boss页面get请求的城市路径
	@RequestMapping(value = "/repository/boss/select/getBossCityPath",method = RequestMethod.GET)
	public String selectBossCityPath(@RequestParam("cityname") String cityname);

	//Boss页面get请求的城市路径
	@RequestMapping(value = "/repository/boss/select/getBossExpPath",method = RequestMethod.GET)
	public String selectBossExpPath(@RequestParam("exp") String exp);

}
