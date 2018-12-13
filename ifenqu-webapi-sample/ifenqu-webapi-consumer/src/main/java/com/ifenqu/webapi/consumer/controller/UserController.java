package com.ifenqu.webapi.consumer.controller;

import com.ifenqu.webapi.consumer.model.User;
import com.ifenqu.webapi.consumer.service.DemoService;
import com.ifenqu.webapi.consumer.service.DemoServiceV2;
import com.ifenqu.webapi.consumer.service.FeignClientManager;
import com.ifenqu.webapi.controller.WebApiController;
import com.ifenqu.webapi.model.OpResult;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;



@Api(tags = "User", description = "User management API")
@RestController
@RequestMapping("")
public class UserController extends WebApiController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DemoService demoService;


    @Autowired
    RestTemplate restTemplate;

    @Autowired
    FeignClientManager feignClientManager;




    @GetMapping("/v1/users/{userId}")
    public OpResult<User> getUser(@PathVariable Integer userId) {

        return demoService.get(userId);
    }

    @GetMapping("/v2/users/{userId}")
    public OpResult<User> getUserV2(@PathVariable Integer userId) {

        DemoServiceV2 demoServiceV2 = feignClientManager.getService(DemoServiceV2.class,"ifenqu-webapi-provider");
        return demoServiceV2.get(userId);
    }

    @GetMapping("/v3/users/{userId}")
    public OpResult<User> getUserV3(@PathVariable Integer userId) {

        return restTemplate.exchange("http://ifenqu-webapi-provider/v1/users/" + userId,
                HttpMethod.GET, new HttpEntity<>(""),
                new ParameterizedTypeReference<OpResult<User>>() {
                }).getBody();
    }

}
