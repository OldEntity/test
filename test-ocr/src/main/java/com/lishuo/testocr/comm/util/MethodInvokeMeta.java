package com.lishuo.testocr.comm.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Program：test
 * @Description：公共工具类
 * @Author：LearnLi
 * @Create:2020-03-26 10:36
 */

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MethodInvokeMeta implements Serializable {

    private static final long serialVersionUID = 8379109667714148890L;
    //接口
    private Class<?> interfaceClass;
    //方法名
    private String methodName;
    //参数
    private Object[] args;
    //返回值类型
    private Class<?> returnType;
    //参数类型
    private Class<?>[] parameterTypes;

}
