package com.reptile.cache.service;

import java.util.List;

public interface CacheManager {
	
	boolean set(String key ,String value);
	boolean set(String key ,String value,long time);
	
	boolean listSet(String key ,Object value);
	boolean listSet(String key, Object value, long time);
	
	boolean hashSet(String key ,Object value);
	boolean hashSet(String key, Object value, long time);
	
	
	
	
	
	
	
	
	
	
	
	
	List<Object> listGet(String key);
	Object get(String key);
	
}
