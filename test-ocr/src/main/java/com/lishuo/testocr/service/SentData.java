package com.lishuo.testocr.service;

import com.lishuo.testocr.service.nettymodule.NettyClient;

/**
 * @Program：test
 * @Description：发送数据
 * @Author：LearnLi
 * @Create:2020-03-26 09:43
 */

public class SentData {

    public static void main(String[] args) {
        new NettyClient("127.0.0.1",2333);
    }



}
