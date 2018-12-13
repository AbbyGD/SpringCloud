package com.ifenqu.webapi.provider.controller;

import com.alibaba.dubbo.rpc.RpcContext;
import com.ifenqu.webapi.controller.WebApiController;
import com.ifenqu.webapi.provider.model.User;
import com.ifenqu.webapi.provider.service.DemoService;
import com.ifenqu.webapi.exception.ApiExCode;
import com.ifenqu.webapi.model.OpResult;
import com.ifenqu.webapi.model.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "User", description = "User management API")
@RestController
@RequestMapping("/v1/users")
public class UserController extends WebApiController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DemoService demoService;



    @ApiOperation(value = "", notes = "结果缓存30分钟")
    @GetMapping()
    public OpResult<PageResult<User>> pagingQueryUsers(@RequestParam(required = false) Integer page) throws Exception {
        if (page == null || page < 0)
            page = 0;

        PageResult<User> pageResult = new PageResult<User>()
                .setTotal(1000);
        return result(pageResult);
    }

    @PostMapping
    public OpResult<User> addUser(@Valid @RequestBody User user, BindingResult bindingResult) {
        OpResult<User> result = new OpResult<>();

        if (bindingResult.hasErrors()) {
            return error(ApiExCode.INVALID_ARGUMENT_ERROR, bindingResult.getFieldError().getField());
        }
        return result(user);
    }

    @GetMapping("/{userId}")
    public OpResult<User> getUser(@PathVariable Integer userId) {
//        NDC.push("hello");
//        MDC.put((new Date()).toString(),"shanghai");
//        ThreadContext.put("loginUser", String.valueOf(getUserId()));
        logger.info("test1,{}", getUserInfo());
        logger.info(MarkerFactory.getMarker("ACCESS_AGENT"), "test2");
        logger.trace("test3");
        logger.debug("test4");
        logger.warn("test5");
        logger.error("test6");


        RpcContext.getContext().setAttachment("requestId",getRequest().getHeader("X-Request-Id"));

        String value = demoService.test("hello");

        logger.info(value);

        User user = demoService.get(100000);

        return result(user);
    }

    @PutMapping("/{userId}")
    public OpResult<User> updateUser(@PathVariable Integer userId, @RequestBody User user) {
        return result(user.setUserId(userId));
    }

    @DeleteMapping("/{userId}")
    public OpResult deleteUser(@PathVariable String userId) {
        return success();
    }
}
