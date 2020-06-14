package com.lishuo.testocr.comm.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Program：test
 * @Description：消息处理类
 * @Author：LearnLi
 * @Create:2020-03-26 14:27
 */

public class RemoteMethodInvokeUtil implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    public Object processMethod(MethodInvokeMeta methodInvokeMeta) throws InvocationTargetException, IllegalAccessException {
        Class interfaceClass = methodInvokeMeta.getInterfaceClass();
        Object bean = applicationContext.getBean(interfaceClass);
        Method[] declaredMethods = interfaceClass.getDeclaredMethods();
        Method method = null;
        for (Method declaredMethod : declaredMethods) {
            if (methodInvokeMeta.getMethodName().equals(declaredMethod.getName())) {
                method = declaredMethod;
            }
        }
        Object invoke = method.invoke(bean, methodInvokeMeta.getArgs());
        return invoke;
    }

    @Override
    public void setApplicationContext(ApplicationContext app) throws BeansException {
        applicationContext = app;
    }
}
