package com.ifenqu.webapi.consumer.service;

import feign.Client;
import feign.Feign;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.cloud.netflix.feign.support.SpringMvcContract;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@Component
@Import(FeignClientsConfiguration.class)
public class FeignClientManagerImpl implements FeignClientManager {
    @Autowired
    Encoder encoder;

    @Autowired
    Decoder decoder;

    @Autowired
    Client client;

    @Override
    public <T> T getService(Class<T> clazz, String name) {
        T target = Feign.builder()
                .client(client)
                .decoder(decoder)
                .encoder(encoder)
                .contract(new SpringMvcContract())
                .target(clazz, "http://" + name);
        return target;
    }
}
