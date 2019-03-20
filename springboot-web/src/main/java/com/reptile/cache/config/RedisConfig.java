package com.reptile.cache.config;

import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonAutoDetect;


/***
 * 
 * redis配置
 * 
 * @author yangsw
 *
 */
@Configuration
public class RedisConfig {


	//	@Bean
	//	public KeyGenerator keyGenerator() {
	//		return new KeyGenerator() {
	//
	//			@Override
	//			public Object generate(Object target, Method method, Object... params) {
	//
	//				StringBuilder sb = new StringBuilder();
	//				sb.append(target.getClass().getName());
	//				sb.append(method.getName());
	//				for (Object object : params) {
	//					sb.append(object.toString());
	//				}
	//				
	//				return sb.toString();
	//			}
	//			
	//		};
	//	}


	@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory){
		RedisTemplate<String, Object> template = new RedisTemplate<>();

		template.setConnectionFactory(connectionFactory);

		Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<>(Object.class);

		ObjectMapper mapper = new ObjectMapper();
		mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

		serializer.setObjectMapper(mapper);

		//value的序列化和反序列化方式使用jackson
		template.setValueSerializer(serializer);

		//使用StringRedisSerializer来序列化和反序列化redis的key值
		template.setKeySerializer(new StringRedisSerializer());

		template.afterPropertiesSet();
		return template;
	}
}
