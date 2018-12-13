package com.ifenqu.webapi.consumer.service;

import com.ifenqu.webapi.consumer.model.User;
import com.ifenqu.webapi.model.OpResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface DemoServiceV2 {

    @GetMapping("/v1/users/{userId}")
    OpResult<User> get(@PathVariable("userId") Integer userId);
}
