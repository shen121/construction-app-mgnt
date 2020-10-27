package com.demo.mgnt.service;

import com.demo.mgnt.config.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class MgntServiceApplicationTests {


    @Autowired
    RedisUtil redisUtil;

    @Test
    void contextLoads() {
        redisUtil.show();
    }

}
