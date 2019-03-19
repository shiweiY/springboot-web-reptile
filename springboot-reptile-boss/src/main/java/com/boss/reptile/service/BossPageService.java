package com.boss.reptile.service;

import java.util.List;

public interface BossPageService {
	
	//获取页面职位信息
	public <T> List<T> getJobList(String pageDoc);
	
}
