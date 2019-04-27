package com.reptile.lagou.service;

import java.util.List;

public interface LagouPageService {

	//获取页面职位信息
	public <T> List<T> getJobList(String pageDoc);
}
