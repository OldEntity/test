package com.lishuo.testjpa.service;

import com.lishuo.testjpa.pojo.User;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * @Program：test
 * @Description：Services
 * @Author：LearnLi
 * @Create:2020-06-08 02:36
 */

public interface UserService {

    /**
     * 获取所有的用户
     * @return
     */
    List<User> getAllUsers();

    /**
     * 保存单个用户
     * @param user
     * @return
     */
    User saveUser(User user);

    /**
     * 更新用户
     * @param user
     * @return
     */
    User updateUser(User user);

    /**
     * 通过用户id删除用户
     * @param id
     * @return
     */
    Integer deleteUserById(Long id);

    List<User> getAllUsersBySort(String pwd);

}
