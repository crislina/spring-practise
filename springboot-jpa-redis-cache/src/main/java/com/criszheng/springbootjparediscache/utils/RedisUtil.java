package com.criszheng.springbootjparediscache.utils;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

/**
 * @author Cris
 * @date 19 Apr 2021
 * @version 1.0
 */

public class RedisUtil {

	public static boolean expire(RedisTemplate<String,Object> redisTemplate, String key, long time) {
		try {
			if(time>0) {
				redisTemplate.expire(key, time,TimeUnit.SECONDS);
			}
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static Long getExpire(RedisTemplate<String,Object> redisTemplate, String key) {
		return redisTemplate.getExpire(key, TimeUnit.SECONDS);
	}
	
	public static boolean hasKey(RedisTemplate<String,Object> redisTemplate, String key) {
		try {
			return redisTemplate.hasKey(key);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void del(RedisTemplate<String, Object> redisTemplate, String... key) {
		if(key!=null && key.length>0) {
			if(key.length==1) {
				redisTemplate.delete(key[0]);
			}else {
				redisTemplate.delete((Collection<String>) CollectionUtils.arrayToList(key));
			}
		}
	}
	
	public static Object get(RedisTemplate<String, Object> redisTemplate,String key) {
		return key==null?null:redisTemplate.opsForValue().get(key);
	}
	
	public static boolean set(RedisTemplate<String, Object> redisTemplate,String key,Object value) {
		try {
			redisTemplate.opsForValue().set(key, value);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean set(RedisTemplate<String, Object> redisTemplate, String key, Object value, long time) {
		try {
			if (time > 0) {
				redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
			} else {
				set(redisTemplate, key, value);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static long incr(RedisTemplate<String, Object> redisTemplate, String key, long delta) {
		if (delta < 0) {
			throw new RuntimeException("increment should be bigger than 0");
		}
		return redisTemplate.opsForValue().increment(key, delta);
	}
	
	public static long decr(RedisTemplate<String, Object> redisTemplate, String key, long delta) {
		if (delta < 0) {
			throw new RuntimeException("increment should be bigger than 0");
		}
		return redisTemplate.opsForValue().increment(key, -delta);
	}
	
}
