package com.lishuo.ocr.constant;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Program：test
 * @Description：常量类
 * @Author：LearnLi
 * @Create:2020-03-27 18:27
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum TypeConstant {


    OCR_TYPE_1011("1001","出租车发票"),
    OCR_TYPE_1002("1002","火车票"),
    OCR_TYPE_1004("1004","增值税发票"),
    OCR_TYPE_1005("1005","增值税电子发票(pdf)"),
    OCR_TYPE_1006("1006","其他票"),
    OCR_TYPE_1013("1013","增值税卷票"),
    OCR_TYPE_1028("1028","定额发票"),
    OCR_TYPE_1029("1029","过路过桥费"),
    OCR_TYPE_1031("1031","火车退票费"),
    OCR_TYPE_1032("1032","飞机行程单"),
    OCR_TYPE_1033("1033","增值税全面票"),
    OCR_TYPE_1035("1035","客车票"),
    OCR_TYPE_2000("2000","通用票据"),
    OCR_TYPE_2003("2003","多票据分割识别"),
    OCR_TYPE_2100("2100","通用票据"),
    OCR_TYPE_2103("2103","多票据分割识别（全字符）"),
    OCR_TYPE_3000("3000","增值税发票查验");







    private String code;
    private String typename;


    //根据code返回msg信息
    public static String getTypeNameByCode(String code){
        for (TypeConstant entry : TypeConstant.values()){
            if(Objects.equals(entry.getCode(),code)){
                return entry.getTypename();
            }
        }
        return "发票格式未被收录";
    }


    //获得全部格式常量
    public static Map<String,String> getAllType(){
        Map<String,String> map=new HashMap<>();
        for (TypeConstant entry : TypeConstant.values()){
            map.put(entry.code,entry.typename);
        }
        return map;
    }

}
