package com.lishuo.testjava.pojo;
import	java.io.DataOutputStream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Program：test
 * @Description：
 * @Author：LearnLi
 * @Create:2019-08-12 13:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tbuser {
    private String username,password;
    private String nickname,userroles;
    private Integer age;

    public void sayHello(){

    }
}
