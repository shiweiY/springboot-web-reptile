package com.reptile.cache.RedisTemp;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/***
 * 
 * Redis 实现类
 * 
 * 对常用方法进行封装,
 * 
 * @author yangsw
 *
 */

@Service
public class RedisHelper implements CacheManager{

	@Autowired
	private RedisTemplate<String,Object> redisTemplate;



	/**
	 * 判断key是否存在	
	 * @param key 键
	 * @return true 存在 false不存在
	 */
	public boolean hasKey(String key) {
		try {
			return redisTemplate.hasKey(key);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	/***
	 * 设置缓存的实效时间
	 * @param key 数据键
	 * @param time 时间/s
	 * @return true/false
	 */
	public boolean expire(String key ,long time) {
		try {
			if(time > 0) {
				redisTemplate.expire(key, time, TimeUnit.SECONDS);
			}
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}




	/***
	 * 
	 * 普通数据置入redis
	 * 
	 * @param key 键
	 * @param value 值
	 * @return boolean true为成功
	 */
	public boolean set(String key ,String value) {
		try {
			redisTemplate.opsForValue().set(key, value);
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
	public boolean set(String key ,String value,long time) {
		try {

			if(time > 0) {
				redisTemplate.opsForValue().set(key, value,time,TimeUnit.SECONDS);
			}else {
				redisTemplate.opsForValue().set(key, value);
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
	public Object get(String key) {
		try {
			return redisTemplate.opsForValue().get(key);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/***
	 * redis list为双向链表		右边入队或者左边入队
	 */
	@Override
	public boolean listSet(String key, Object value) {
		try {
//			redisTemplate.opsForList().rightPush(key, value);
			redisTemplate.opsForList().leftPush(key, value);

		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	/***
	 * redis list为双向链表 
	 */
	@Override
	public boolean listSet(String key, Object value, long time) {
		try {

			redisTemplate.opsForList().leftPush(key, value);
			if(time > 0) {
				expire(key, time);
			}
			return true;


		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/****
	 * 获取List
	 * @param key
	 * @return
	 */
	@Override
	public List<Object> listGet(String key) {
		try {
			
			//0和-1表示从0下标到最大下标，也就是整个List
//			return (List<Object>) redisTemplate.opsForList().range(String key, long start, long end)
			
			//左出列或右出列		
			return (List<Object>) redisTemplate.opsForList().leftPop(key);
//			return (List<Object>) redisTemplate.opsForList().rightPop(key);

		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	@Override
	public boolean hashSet(String key, Object value) {
		try {

			return true;


		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public boolean hashSet(String key, Object value, long time) {
		// TODO Auto-generated method stub
		return false;
	}






}
