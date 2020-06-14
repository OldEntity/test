package com.lishuo.testjpa;

import com.lishuo.testjpa.pojo.User;
import com.lishuo.testjpa.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestJpaApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(TestJpaApplicationTests.class);

    @Resource
    private UserService userService;

    @Test
    public void contextLoads() {

        findAllSortEsc();

    }


    void add() {
        String uuid = UUID.randomUUID().toString();

        User user = new User().builder()
                .id(1111L)
                .account("LearnLi")
                .name("李学习")
                .pwd(uuid)
                .build();
        user = userService.saveUser(user);
        logger.info("用户{}增加成功", user.getName());

    }


    void delete() {
        userService.deleteUserById(1111L);
        logger.info("id {} 的用户已删除！", 1111L);
    }

    void update() {
        String uuid = UUID.randomUUID().toString();

        User user = new User().builder()
                .id(1111L)
                .account("HIHI")
                .name("李戒烟")
                .pwd(uuid)
                .build();
        user = userService.saveUser(user);
        logger.info("用户{}修改成功", user.getName());

    }

    void findAll(){
        List<User> users= userService.getAllUsers();
        users.stream().forEach(user -> {
            logger.info("获得的用户为{}",user);
        });
    }

    void findAllSortEsc(){
        List<User> users= userService.getAllUsers();
        users.stream().forEach(user -> {
            logger.info("排序前获得的用户为{}",user);
        });

        users=userService.getAllUsersBySort("301c3e19-d962-4584-ba32-acfffe22c0d7");
        System.out.println("---------------------");
        users.stream().forEach(user -> {
            logger.info("排序后获得的用户为{}",user);
        });


    }



}
