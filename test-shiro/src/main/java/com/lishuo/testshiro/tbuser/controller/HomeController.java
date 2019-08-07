package com.lishuo.testshiro.tbuser.controller;

import com.lishuo.testshiro.tbuser.entity.LoginResult;
import com.lishuo.testshiro.tbuser.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Program：test
 * @Description：
 * @Author：LearnLi
 * @Create:2019-08-02 14:55
 */
@RestController
public class HomeController {
    @Resource
    private LoginService loginService;

    @RequestMapping({"/","/index"})
    public String index(){
        return"假装显示index";
    }

    @RequestMapping("/403")
    public String unauthorizedRole(){
        System.out.println("------没有权限-------");
        return "假装显示403";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String toLogin(Map<String, Object> map, HttpServletRequest request)
    {
        loginService.logout();
        return "/user/login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(Map<String, Object> map, HttpServletRequest request) throws Exception{
        System.out.println("login()");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        LoginResult loginResult = loginService.login(userName,password);
        if(loginResult.isLogin())
        {
            return "/index";
        }
        else {
            map.put("msg",loginResult.getResult());
            map.put("userName",userName);
            return "/user/login";
        }
    }

    @RequestMapping("/logout")
    public String logOut(HttpSession session) {
        loginService.logout();
        return "/user/login";
    }
}
