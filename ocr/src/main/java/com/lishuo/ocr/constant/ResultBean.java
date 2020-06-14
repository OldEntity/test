package com.lishuo.ocr.constant;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;

import java.io.Serializable;

/**
 * @Program：test
 * @Description：封装返回格式
 * @Author：LearnLi
 * @Create:2020-03-27 19:27
 */

@Data
@NoArgsConstructor
@Builder(toBuilder = true)
@AllArgsConstructor(access= AccessLevel.PRIVATE)
public class ResultBean<T> implements Serializable {
    private static final long serialVersionUID= 8676131899637805509L;

    //返回编码
    private String code;
    //返回信息
    private String msg;
    //签名
    private String sign="";
    //返回数据封装
    @Builder.Default
    private T data =(T) "";

}
