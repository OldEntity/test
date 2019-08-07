package com.lishuo.testshiro.tbuser.dao;

import com.lishuo.testshiro.tbuser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Program：test
 * @Description：
 * @Author：LearnLi
 * @Create:2019-08-02 14:31
 */

public interface UserDao extends JpaRepository<User,Integer> {
    User findByUserName(String userName);
}
