package com.lishuo.testshiro.tbuser.service;

import com.lishuo.testshiro.tbuser.entity.User;

/**
 * @Program：test
 * @Description：
 * @Author：LearnLi
 * @Create:2019-08-02 14:35
 */


public interface UserService {
    User findByUserName(String userName);
}
