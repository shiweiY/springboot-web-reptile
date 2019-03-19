package com.reptile.cache;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/***
 * 
 * Redis 实现类
 * 
 * @author yangsw
 *
 */
public class RedisHelper {
	
	@Autowired
	private static RedisTemplate<String, Object> REDIS;
	
	
	
	
	/***
	 * 
	 * 普通数据置入redis
	 * 
	 * @param key 键
	 * @param value 值
	 * @return boolean true为成功
	 */
	public static boolean set(String key ,String value) {
		try {
			REDIS.opsForValue().set(key, value);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	/***
	 * 
	 * 普通数据置入redis 并设置过期时间
	 * 
	 * @param key 键
	 * @param value 值
	 * @param time 过期时间  以秒为单位
	 * @return boolean true为成功
	 */
	public static boolean set(String key ,String value,long time) {
		try {
			
			if(time > 0) {
				REDIS.opsForValue().set(key, value,time,TimeUnit.SECONDS);
			}else {
				REDIS.opsForValue().set(key, value);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	
	/***
	 * 
	 * 获取普通数据
	 * @param <T>
	 * 
	 * @param key 键
	 * @param value 值
	 * @return Object
	 */
	public static Object get(String key) {
		try {
			return REDIS.opsForValue().get(key);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	
}
