package com.lishuo.testjava.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Program：test
 * @Description：
 * @Author：LearnLi
 * @Create:2019-10-29 16:29
 */

public class MD5Demo {

    public static void test() throws NoSuchAlgorithmException {
        String plainText="LearnLi!";
        MessageDigest md5 = MessageDigest.getInstance("md5");
        byte[] cipherData = md5.digest(plainText.getBytes());
        StringBuffer builder=new StringBuffer();
        for (byte cipher:cipherData) {
            String toHexStr=Integer.toHexString(cipher & 0xff);
            builder.append(toHexStr.length()==1?"0"+toHexStr:toHexStr);
        }
        System.out.println(builder.toString());
    }


    public static void main(String[] args) throws NoSuchAlgorithmException {
     //   test();
        byte [] bytes=new byte[1];

    }



}
