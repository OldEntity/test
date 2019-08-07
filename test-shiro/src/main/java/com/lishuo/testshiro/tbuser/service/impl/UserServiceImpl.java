package com.lishuo.testshiro.tbuser.service.impl;

import com.lishuo.testshiro.tbuser.dao.UserDao;
import com.lishuo.testshiro.tbuser.entity.User;
import com.lishuo.testshiro.tbuser.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Program：test
 * @Description：
 * @Author：LearnLi
 * @Create:2019-08-02 14:36
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userdao;

    @Override
    public User findByUserName(String userName) {
        return userdao.findByUserName(userName);
    }
}
