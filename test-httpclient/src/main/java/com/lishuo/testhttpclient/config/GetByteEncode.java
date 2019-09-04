package com.lishuo.testhttpclient.config;

import org.mozilla.universalchardet.UniversalDetector;

/**
 * @Program：test
 * @Description：
 * @Author：LearnLi
 * @Create:2019-08-25 14:47
 */

public class GetByteEncode {



    /**
     * 获取文件编码类型
     *
     * @param bytes 文件bytes数组
     * @return      编码类型
     */
    public static String getEncoding(byte[] bytes) {
        String defaultEncoding = "UTF-8";
        UniversalDetector detector = new UniversalDetector(null);
        detector.handleData(bytes, 0, bytes.length);
        detector.dataEnd();
        String encoding = detector.getDetectedCharset();
        detector.reset();
        System.out.println("字符编码是："+encoding);;
        if (encoding == null) {
            encoding = defaultEncoding;
        }
        return encoding;
    }
}
