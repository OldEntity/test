package com.lishuo.testjpa.service;

import com.lishuo.testjpa.param.UserDetailParam;
import com.lishuo.testjpa.pojo.UserDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserDetailService {
    public Page<UserDetail> findByCondition(UserDetailParam detailParam, Pageable pageable);
}
