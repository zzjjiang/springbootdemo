package com.jone;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class SpringbootdemoApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("hello world");
    }

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void setVal(){
        redisTemplate.boundValueOps("test").set("0109");
    }

}
