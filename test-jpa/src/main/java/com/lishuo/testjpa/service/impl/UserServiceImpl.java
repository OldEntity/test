package com.lishuo.testjpa.service.impl;


import com.lishuo.testjpa.dao.UserDao;
import com.lishuo.testjpa.pojo.User;
import com.lishuo.testjpa.service.UserService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Program：test
 * @Description：业务层实现类
 * @Author：LearnLi
 * @Create:2020-06-08 02:42
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;


    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userDao.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userDao.save(user);
    }

    @Override
    public Integer deleteUserById(Long id) {
        userDao.deleteById(id);
        return 0;
    }

    @Override
    public List<User> getAllUsersBySort(String pwd) {
        Sort sort=new Sort(Sort.Direction.ASC,"account");
        List<User> list=userDao.findAllByPwd(pwd,sort);

        return list;
    }

}
