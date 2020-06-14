package com.lishuo.testocr.comm.util;

import java.lang.reflect.Method;

/**
 * @Program：test
 * @Description：获取 method的元数据信息
 * @Author：LearnLi
 * @Create:2020-03-26 14:11
 */

public class WrapMethodUtils {

    /**
     * 获取 method的元数据信息
     *
     * @param interfaceClass
     * @param method
     * @param args
     * @return
     */
    public static MethodInvokeMeta readMethod(Class interfaceClass, Method method, Object[] args) {
        MethodInvokeMeta mim = new MethodInvokeMeta();
        mim.setInterfaceClass(interfaceClass);
        mim.setArgs(args);
        mim.setMethodName(method.getName());
        mim.setReturnType(method.getReturnType());
        Class<?>[] parameterTypes = method.getParameterTypes();
        mim.setParameterTypes(parameterTypes);
        return mim;
    }
}
