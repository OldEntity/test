package com.lishuo.testjava.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @Program：test
 * @Description：start class
 * @Author：LearnLi
 * @Create:2020-05-31 11:44
 */

public class main {


    public static void main(String[] args) {
        Map<String,String> map=new HashMap<>();
        map.put("w","ww");
        System.out.println(map.containsKey("w"));
    }
}
