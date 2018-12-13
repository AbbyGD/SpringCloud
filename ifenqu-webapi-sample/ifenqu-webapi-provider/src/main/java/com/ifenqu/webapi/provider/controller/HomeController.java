package com.ifenqu.webapi.provider.controller;

import com.ifenqu.webapi.controller.WebApiController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alphie on 09/08/2017.
 */
@RestController
public class HomeController extends WebApiController {

    @GetMapping("/")
    public String home() {
        return "Welcome webapi provider!" + getPlatform();
    }
}
