package com.lishuo.testshiro.tbuser.dao;

import com.lishuo.testshiro.tbuser.entity.Tbuser;
import com.lishuo.testshiro.tbuser.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

/**
 * @Program：TestSpringCloud
 * @Description：
 * @Author：LearnLi
 * @Create:2019-04-03 18:13
 */
@Component
public interface TbuserDao extends JpaRepository<Tbuser,Integer> {

    @Query("from Tbuser where userid =:userid ")
    public Tbuser getUser(@Param("userid") Integer id);


    @Query("from Tbuser where username =:username and password=:password")
    public Tbuser login(@Param("username") String username,@Param("password") String password);

}
/*@Mapper
public interface TbuserDao {

    @Select("select * from tbuser where username=#{user.username} and password=#{user.password}")
    Tbuser login(@Param("user") Tbuser user);

    @Select("select * from tbuser where userid = #{id}")
    Tbuser detail(@Param("id") Integer id);

}*/
