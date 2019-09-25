package com.lishuo.testwebsocket.controller;

import com.lishuo.testwebsocket.config.WebSocketServer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Program：test
 * @Description：
 * @Author：LearnLi
 * @Create:2019-09-23 17:57
 */

@Controller
public class PageController {

    @RequestMapping("/")
    public String hello(){
        return "hello.html";
    }

    @PostMapping("/page")
    public String page(Model modle, @Param("username")String username){
        modle.addAttribute("username",username);
        return "MyPage";
    }
    @RequestMapping("ajaxSendMsg")
    @ResponseBody
    public String getOnlineState(String name,String msg){
        String result="";
        try {
            WebSocketServer.sendInfo(name+msg,"all");
            result="发送成功";
        } catch (IOException e) {
            result="发送失败";
        }

        return result;
    }




}
