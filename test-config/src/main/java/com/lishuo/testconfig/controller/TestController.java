package com.lishuo.testconfig.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Program：test
 * @Description：测试
 * @Author：LearnLi
 * @Create:2019-04-25 01:49
 */
@RestController
@RefreshScope
public class TestController {
    /*@Value("${version}")
    private String version;*/

    @Value("${server.port}")
    private String port;

    @RequestMapping("/getPort")
    public String  getVersion(){
        return this.port;
    }




}
