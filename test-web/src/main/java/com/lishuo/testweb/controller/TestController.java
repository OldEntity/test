package com.lishuo.testweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Program：test
 * @Description：
 * @Author：LearnLi
 * @Create:2019-09-11 10:49
 */
@Controller
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "hello.html";
    }


}
