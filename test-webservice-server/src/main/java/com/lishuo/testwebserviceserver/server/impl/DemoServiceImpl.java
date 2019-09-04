package com.lishuo.testwebserviceserver.server.impl;

import com.lishuo.testwebserviceserver.server.DemoService;

import javax.jws.WebService;

/**
 * @Program：test
 * @Description：
 * @Author：LearnLi
 * @Create:2019-09-04 14:34
 */
@WebService(serviceName = "DemoService",targetNamespace = "http://server.testwebserviceserver.lishuo.com",endpointInterface = "com.lishuo.testwebserviceserver.server.DemoService")
public class DemoServiceImpl implements DemoService {
    @Override
    public String hello(String name) {
        return "Hello "+name;
    }
}
