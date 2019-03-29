package com.reptile.web.tech.cache.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class CacheClient implements CacheManager {
	Logger log = LoggerFactory.getLogger(CacheClient.class);
	private JedisPool jedisPool;
	private boolean flag = false;

	public CacheClient(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}

	/***
	 * 普通数据放入
	 */
	public String setString(String key, String value) {
		Jedis jedis = getJedis();

		if(!key.isEmpty()){
			try {
				jedis.set(key, value);
				flag = true;
			}finally {
				if(flag) {
					jedis.close();
					flag = false;
				}
			}

		}

		return null;
	}

	/***
	 * 普通数据取出
	 */
	public String getString(String key) {
		String value= "";
		if(!key.isEmpty()) {
			Jedis jedis = this.getJedis();
			try {
				value = jedis.get(key);
				flag = true;
			} finally {
				if(flag) {
					jedis.close();
					flag = false;
				}
			}
		}
		return value;
	}



	/***
	 * Obj数据放入
	 */
	public void setSerialData(String key, Object value) {
		Jedis jedis = null;
		if(!key.isEmpty()) {
			try {
				jedis = this.getJedis();
				jedis.set(key.getBytes(), serialize(value));
				flag = true;
			} finally {
				if(jedis != null) {
					jedis.close();
					flag = false;
				}
			}

		}

	}

	/***
	 * Obj数据取出
	 */
	public Object getSerialData(String key) {
		Jedis jedis = null;
		Object obj = null;

		if(!key.isEmpty()) {
			try {
				jedis = this.getJedis();
				byte[] bt = jedis.get(key.getBytes());

				obj = unserialize(bt);

			} finally {
				if(jedis != null) {
					jedis.close();
					flag = false;
				}
			}
		}

		return obj;
	}


	/***
	 * redis Hash类型数据放入
	 * @param key 键
	 * @param field 域
	 * @param value 值
	 */
	public void hset(String key, String field, String value) {
		Jedis jedis = null;
		if(checkIsNull(key,field,value)) {
			try {
				jedis = this.getJedis();
				jedis.hset(key, field, value);

			} finally {
				if(jedis != null) {
					jedis.close();
					flag = false;
				}
			}
		}
	}
	
	/***
	 * redis Hash类型数据取出
	 * @param key 键
	 * @param field 域
	 * @return String 
	 */
	public String hget(String key, String field) {
		Jedis jedis = null;
		if(checkIsNull(key,field)) {
			try {
				jedis = this.getJedis();
				return jedis.hget(key, field);
			} finally {
				if(jedis != null) {
					jedis.close();
					flag = false;
				}
			}
		}
		
		return "";
	}


	/***
	 * 判断值是否为空
	 * @param strs
	 * @return 为空则返回false
	 */
	public boolean checkIsNull(Object... obj) {
		for (Object string : obj) {
			if(string == null || string.toString().isEmpty()) {
				return false;
			}
		}
		return true;
	}





























	/***
	 * 从Jedis池中获取一个jedis
	 * @return
	 */
	public Jedis getJedis() {
		return this.jedisPool.getResource();
	}

	/***
	 * Object序列化
	 * @param obj
	 * @return
	 */
	public byte[] serialize(Object obj){
		byte[] bt ;
		if(obj != null){
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			try {
				ObjectOutputStream os = new ObjectOutputStream(baos);
				os.writeObject(obj);

				bt = baos.toByteArray();

				return bt;
			} catch (IOException e) {
				e.printStackTrace();
				log.error("serialize对象序列化失败: "+e.getMessage());
			}
		}

		return null;
	}

	/***
	 * 反序列化Object
	 * @param bt
	 * @return
	 */
	public Object unserialize(byte[] bt){
		Object obj;
		if(bt != null && bt.length > 0){
			ByteArrayInputStream bais = new ByteArrayInputStream(bt);
			try {
				ObjectInputStream ois = new ObjectInputStream(bais);
				obj = ois.readObject();

				return obj;
			} catch (Exception e) {
				e.printStackTrace();
				log.error("unserialize对象反序列化失败: "+e.getMessage());
			}
		}

		return null;
	}

}
