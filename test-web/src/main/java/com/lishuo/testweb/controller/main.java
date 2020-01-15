package com.lishuo.testweb.controller;

/**
 * @Program：test
 * @Description：
 * @Author：LearnLi
 * @Create:2019-11-06 15:26
 */

public class main {
    public static void main(String[] args) {
        String a="<result>abcdefg</result>";
        int an=a.indexOf("<result>");
        int bn=a.indexOf("</result>");
        System.out.println(a.substring(an,bn));


    }
}
