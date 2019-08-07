package com.lishuo.testshiro.tbuser.entity;

import lombok.Data;

/**
 * @Program：test
 * @Description：
 * @Author：LearnLi
 * @Create:2019-08-02 14:27
 */

public class LoginResult {
    private boolean isLogin = false;
    private String result;



    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
