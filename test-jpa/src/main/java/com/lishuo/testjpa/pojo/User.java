package com.lishuo.testjpa.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Program：test
 * @Description：用户实体类
 * @Author：LearnLi
 * @Create:2020-06-08 01:09
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "AUTH_USER")
public class User {

    @Id
    private Long id;
    @Column(length = 32,name = "USER_NAME")
    private String name;
    @Column(length = 32,name = "USER_account")
    private  String account;
    @Column(length = 64,name = "USER_PWD")
    private String pwd;



}
