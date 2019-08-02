package com.lishuo.svc;

import java.util.ArrayList;
import java.util.List;

/**
 * @Program：test
 * @Description：
 * @Author：LearnLi
 * @Create:2019-04-30 09:18
 */

public class StringSplit {


    /**通过逗号分割字符串，但是字段内含逗号*/
    public static void main(String[] args) {
        String a = "3,Jerry,\"羽毛球,爬山\",55.6,1980-5-26";
        String[] aa = commaDivider(a);
        System.out.println(aa[2]);
    }

    /***
     * @param sss
     * sss为一行内容
     * @return
     */
    public static String[] commaDivider(String sss) {
        //双引号开始标记
        int qutationStart = 0;
        //双引号结束标记
        int qutationEnd = 0;
        char[] charStr = sss.toCharArray();
        //用于拼接字符 作为一个字段值
        StringBuffer sbf = new StringBuffer();
        //结果list
        List<String> list = new ArrayList<>();
        //逐个字符处理
        for (int i = 0; i < charStr.length; i++) {
            //在此之前还未遇到双引号并且当前的字符为\"
            if (qutationStart == 0 && charStr[i] == '\"') {

                qutationStart = 1;
                qutationEnd = 0;
                continue;
            } else if (qutationStart == 1 && charStr[i] == '\"') {
                //在此之前遇到了双引号并且当前的字符为\" 说明字段拼接该结束了
                qutationStart = 0;
                qutationEnd = 1;
                //当最后一个字符是双引号时，由于下次循环不会执行，所以在此保存一下
                if (i == charStr.length - 1 && sbf.length() != 0) {
                    list.add(sbf.toString());
                    sbf.setLength(0);
                }
                continue;
            } else if (qutationStart == 1 && charStr[i] == ',' && qutationEnd == 0) {
                //处理不规范字符
                sbf.append(charStr[i]);
                continue;
            } else if (charStr[i] == ',') {
                //字段结束，将拼接好的字段值存到list中
                list.add(sbf.toString());
                sbf.setLength(0);
                continue;
            }
            //不属于分隔符的就拼接
            sbf.append(charStr[i]);
            if (i == charStr.length - 1 && sbf.length() != 0) {
                list.add(sbf.toString());
                sbf.setLength(0);
            }
        }
        return (String[]) list.toArray(new String[list.size()]);
    }
}
