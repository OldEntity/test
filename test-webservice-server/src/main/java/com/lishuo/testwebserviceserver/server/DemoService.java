package com.lishuo.testwebserviceserver.server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @Program：test
 * @Description：
 * @Author：LearnLi
 * @Create:2019-09-04 14:34
 */
@WebService
public interface DemoService {

    @WebMethod
    String hello(@WebParam(name = "name")String name);

}
