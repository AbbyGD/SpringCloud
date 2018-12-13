package com.ifenqu.webapi.consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Alphie on 2018/9/12.
 */

@Configuration
public class WebConfig {
    @Bean
    @LoadBalanced//Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端       负载均衡的工具。
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
