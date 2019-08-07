package com.lishuo.testshiro.tbuser.service.impl;

import com.lishuo.testshiro.tbuser.dao.TbuserDao;
import com.lishuo.testshiro.tbuser.entity.Tbuser;
import com.lishuo.testshiro.tbuser.service.TbuserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Program：TestSpringCloud
 * @Description：
 * @Author：LearnLi
 * @Create:2019-04-03 18:19
 */
@Service
public class TbuserServiceImpl implements TbuserService {

    @Resource
    private TbuserDao td;


    @Override
    public Tbuser getUser(Integer id) {
        return td.getUser(id);
    }

    @Override
    public List<Tbuser> findAll() {
        return td.findAll();
    }

    @Override
    public Tbuser login(String username, String password) {
        return td.login(username,password);
    }
}
/*@Service
public class TbuserServiceImpl implements TbuserService {

    @Resource
    private TbuserDao td;

    @Override
    public Tbuser login(Tbuser user) {
        return td.login(user);
    }

    @Override
    public Tbuser detail(Integer id) {
        return td.detail(id);
    }
}*/
