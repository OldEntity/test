package com.lishuo.testshiro.tbuser.service;


import com.lishuo.testshiro.tbuser.entity.Tbuser;

import java.util.List;

/**
 * @Program：TestSpringCloud
 * @Description：
 * @Author：LearnLi
 * @Create:2019-04-03 18:19
 */


public interface TbuserService {
    public Tbuser getUser(Integer id);
    public List<Tbuser> findAll();
    public Tbuser login(String username,String password);

}

/*public interface TbuserService {

    Tbuser login(Tbuser user);

    Tbuser detail(Integer id);
}*/
