package com.reptile.cache.service;


public interface CacheManager {
	
	//字符串数据
	String setString(String key,String value);
	String getString(String key);
	
	//Object
	void setSerialData(String key,Object value);
	Object getSerialData(String key);
	
}
