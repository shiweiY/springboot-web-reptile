package com.reptile.web.tech.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.reptile.web.mapper.Main2RepositoryMapper;
import com.reptile.web.tech.cache.service.RedisHelper;

/***
 * 启动后初始化页面热门城市标签
 * @author shiwei
 *
 */

@Component
@Order(1)
public class StartedInitHotCityRunner implements CommandLineRunner {

	@Autowired
	Main2RepositoryMapper brmapper;

	@Override
	public void run(String... args) throws Exception {
		List<Object> hotcity = brmapper.getHotCity();

		RedisHelper.setSerialData("mainPage_hotcity", hotcity);
	}

}
