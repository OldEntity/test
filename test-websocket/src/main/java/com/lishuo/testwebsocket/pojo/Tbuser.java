package com.lishuo.testwebsocket.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Program：test
 * @Description：
 * @Author：LearnLi
 * @Create:2019-08-09 09:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tbuser {
    private String usernmae;
    private String password;
    private String mgs;

}
