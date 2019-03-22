package com.reptile.cache.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RedisHelper extends JedisClient{
	Logger log = LoggerFactory.getLogger(RedisHelper.class);

	public static String setString(String key, String value) {
		return cache.setString(key, value);
	}
	public static String getString(String key) {
		return cache.getString(key);
	}

	
	public static void setSerialData(String key,Object value) {
		cache.setSerialData(key, value);
	}
	
	public static Object getSerialData(String key) {
		return cache.getSerialData(key);
	}



















}
