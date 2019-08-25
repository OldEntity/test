package com.lishuo.testwebsocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Program：test
 * @Description：
 * @Author：LearnLi
 * @Create:2019-08-08 09:47
 */
@RequestMapping("/api/websocket")
@Controller
public class TestController {

    @GetMapping("/page")
    public String changePassword(){
        return "page";
    }


}
