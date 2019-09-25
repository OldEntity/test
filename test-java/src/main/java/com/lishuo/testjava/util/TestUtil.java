package com.lishuo.testjava.util;

import com.lishuo.testjava.queue.main;

/**
 * @Program：test
 * @Description：
 * @Author：LearnLi
 * @Create:2019-09-05 11:14
 */

public class TestUtil {

    public static void main(String[] args) {
        String date="二零一九年一十三月二十八日";
        int y= date.indexOf("年");
        int m= date.indexOf("月");
        int d= date.indexOf("日");
        System.out.println(y+"---"+m+"---"+d);


        System.out.println(date.substring(0,y));
        System.out.println(date.substring(y+1,m));
        System.out.println(date.substring(m+1,d));
    }

}
