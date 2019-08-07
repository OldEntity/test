package com.lishuo.testshiro;

import com.lishuo.testshiro.tbuser.entity.Tbuser;
import com.lishuo.testshiro.tbuser.service.TbuserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestShiroApplicationTests {



    @Resource
    private DataSource ds;
    @Test
    public void contextLoads() {

        try {
            System.out.println(ds.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Resource
    private TbuserService ts;
    @Test
    public void testQuery(){
        /*System.out.println(ts.login(new Tbuser("admin","12345")));*/
        System.out.println(ts.getUser(72));
    }


}
