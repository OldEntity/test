package com.lishuo.testjava.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @Program：test
 * @Description：
 * @Author：LearnLi
 * @Create:2019-10-17 19:30
 */

public class MapSource {


    public static void main(String[] args) {
        Map<String,String> map=new HashMap<>();
        map.put("ss","ss");
        System.out.println(map.containsKey("ss"));


    }

}
