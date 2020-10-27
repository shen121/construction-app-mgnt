package com.demo.mgnt.config.util;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class RedisUtil {

    @Autowired
    public StringRedisTemplate stringRedisTemplate;

    public void setCatch(String key,Object obj){
        if(stringRedisTemplate.hasKey(key)){
            throw new RuntimeException("The key is existence");
        }
        stringRedisTemplate.opsForValue().set(key, JSON.toJSONString(obj));
    }

    public <T>T getCatch(String key,Class<T> tClass){
        String s = stringRedisTemplate.opsForValue().get(key);
        T t = JSON.parseObject(s, tClass);
        return t;
    }




}
