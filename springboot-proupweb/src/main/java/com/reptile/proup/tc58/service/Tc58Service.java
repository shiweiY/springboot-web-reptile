package com.reptile.proup.tc58.service;

public interface Tc58Service {
	//向数据库中更新58同城的城市信息
	public boolean cityInfoUpdate(String page);

	//更新58同城在DB中参数的映射
	public boolean updateQueryParams(String page);
}
