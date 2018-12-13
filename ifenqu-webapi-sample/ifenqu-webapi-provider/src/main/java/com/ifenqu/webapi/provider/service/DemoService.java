package com.ifenqu.webapi.provider.service;

import com.ifenqu.webapi.provider.model.User;

public interface DemoService {
    String test(String args);
    User get(int id);
}
