package com.ifenqu.webapi.consumer.controller;


import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Alphie on 2018/9/11.
 */
@RestController
public class HomeController {

    @Qualifier("discoveryClient")
    @Autowired
    private DiscoveryClient client;
    @GetMapping
    public Object home() {
        List<String> services = client.getServices();

        return services.stream().map(p->client.getInstances(p)).collect(Collectors.toList());

    }
}
