package com.reptile.tc58.service;

import java.util.List;

public interface Tc58PageService {

	//获取页面职位信息
	public <T> List<T> getJobList(String pageDoc);
}
