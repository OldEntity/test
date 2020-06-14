package com.lishuo.testjpa.dao;

import com.lishuo.testjpa.pojo.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Program：test
 * @Description：用户dao层
 * @Author：LearnLi
 * @Create:2020-06-08 02:16
 */

@Repository
public interface UserDao extends JpaRepository<User,Long> {

    List<User> findAllByPwd(String pwd, Sort sort);

}
