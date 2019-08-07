package com.lishuo.testshiro.tbuser.service;

import com.lishuo.testshiro.tbuser.entity.LoginResult;

/**
 * @Program：test
 * @Description：
 * @Author：LearnLi
 * @Create:2019-08-02 14:35
 */


public interface LoginService {
    LoginResult login(String userName, String password);
    void logout();
}
