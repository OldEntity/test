package com.lishuo.testjpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Program：test
 * @Description：
 * @Author：LearnLi
 * @Create:2019-09-11 14:11
 */
@Controller
public class TestController {
    @RequestMapping("/test")
    public String test(){
        return "hello.html";
    }

}
