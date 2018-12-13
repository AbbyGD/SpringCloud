package com.ifenqu.webapi.provider.service;

import com.ifenqu.webapi.provider.mapper.AccountUserMapper;
import com.ifenqu.webapi.provider.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DemoServiceIml implements DemoService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AccountUserMapper mapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public String test(String args) {
        logger.info("dubbo:{}", args);
        String key = "provider:test";
        stringRedisTemplate.opsForValue().set(key, (new Date()).toString());

        String value = stringRedisTemplate.opsForValue().get(key);

        logger.info("value:{}", value);

        return String.format("args:{},time:{}", value);
    }

    @Override
    public User get(int id) {
        return mapper.get(id);
    }
}
