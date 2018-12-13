package com.ifenqu.webapi.consumer.service;

public interface FeignClientManager {
    <T> T getService(Class<T> clazz, String name);
}
