package com.lishuo.testshiro.tbuser.controller;

import com.lishuo.testshiro.tbuser.entity.Tbuser;
import com.lishuo.testshiro.tbuser.service.TbuserService;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Program：TestSpringCloud
 * @Description：
 * @Author：LearnLi
 * @Create:2019-04-03 18:20
 */
@RestController
public class TbuserController {

    @Resource
    private TbuserService ts;

    /*@RequestMapping(value = "/login", method = RequestMethod.POST)
    public Tbuser login(@RequestBody Tbuser user) {
        return ts.login(user);
    }*/
    @RequestMapping(value = "/queryAll", method = RequestMethod.GET)
    public List<Tbuser> queryAll() {

        return ts.findAll();
    }

    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public Tbuser detail(@RequestParam("id") Integer id) {

        return ts.getUser(id);
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Tbuser login(@RequestParam("password") String username,@RequestParam("password") String password) {

        //return ts.getUser(id);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        System.out.println("token==============================="+token);
        return ts.login(username,password);
    }

}
