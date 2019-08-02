package com.lishuo.svc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Program：test
 * @Description：
 * @Author：LearnLi
 * @Create:2019-04-30 09:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pojo implements Serializable {

    private Integer a_int;
    private String b_str;
    private String c_str;
    private Float d_float;
    private String e_date;

    @Override
    public String toString() {
        return a_int + "\t" + b_str + "\t" + c_str + "\t" + d_float + "\t" +"\'"+ e_date+"\'" + "\r\n";
    }


}
