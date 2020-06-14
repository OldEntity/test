package com.lishuo.testocr.comm.util;

import java.io.Serializable;

/**
 * @Program：test
 * @Description：空异常处理
 * @Author：LearnLi
 * @Create:2020-03-26 11:04
 */

public class NullWritable implements Serializable {
    private static final long serialVersionUID = -8191640400484155111L;
    private static NullWritable instance = new NullWritable();

    private NullWritable() {
    }

    public static NullWritable nullWritable() {
        return instance;
    }
}
