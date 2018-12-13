package com.ifenqu.webapi.provider;

/**
 * Created by Alphie on 2018/9/11.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 实际项目中，请删除此文件
 */
@Component
public class StartChecker implements ApplicationRunner {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StringRedisTemplate stringRedisTemplate;


    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {

        String key = "StartChecker";
        String value = new Date().toString();

        stringRedisTemplate.opsForValue().set(key, value);
        value = stringRedisTemplate.opsForValue().get(key);

        logger.info("StartChecker: {}", value);
    }
}
