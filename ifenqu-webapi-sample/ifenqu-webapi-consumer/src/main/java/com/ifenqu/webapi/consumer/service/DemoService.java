package com.ifenqu.webapi.consumer.service;

import com.ifenqu.webapi.consumer.model.User;
import com.ifenqu.webapi.model.OpResult;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "ifenqu-webapi-provider")
public interface DemoService {

    @GetMapping("/v1/users/{userId}")
    OpResult<User> get(@PathVariable("userId") Integer userId);
}
