package com.ifenqu.webapi.provider.controller;

import com.ifenqu.webapi.controller.ThirdController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alphie on 09/08/2017.
 */
@RestController
@RequestMapping("/third/v1/")

public class ThirdOrderController extends ThirdController {

    @GetMapping("/test")
    public String home() {
        return "Welcome webapi provider!";
    }
}
