package com.ifenqu.webapi.provider.config;

import com.alibaba.dubbo.config.spring.ReferenceBean;
import com.ifenqu.account.api.*;
import com.ifenqu.commons.dubbo.DubboConfigAbstract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ImportAutoConfiguration(value = com.ifenqu.commons.dubbo.DubboAutoConfiguration.class)
public class DubboConfig extends DubboConfigAbstract{



    @Bean
    public ReferenceBean<AccountService> accountService() {
        return createReferenceBean(AccountService.class);
    }

    @Bean
    public ReferenceBean<ThirdAppService> thirdAppService() {
        return createReferenceBean(ThirdAppService.class);
    }


//    @Bean
//    public ReferenceBean<DemoService> demoService() {
//        return createReferenceBean(DemoService.class);
//    }
//
//
//    @Bean
//    public ServiceBean<DemoService> demoServiceImpl() {
//        return createServiceBean(DemoService.class, new DemoServiceIml());
//    }
}
