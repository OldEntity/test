package com.lishuo.testocr.comm.util;

import com.lishuo.testocr.service.nettymodule.RPCProxyFactoryBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import java.util.List;

/**
 * @Program：test
 * @Description：动态加载bean到bean工厂
 * @Author：LearnLi
 * @Create:2020-03-26 11:22
 */

public class NettyBeanSacnner implements BeanFactoryPostProcessor {

    private DefaultListableBeanFactory beanFactory;

    private String basePackage;

    private String clientName;

    public NettyBeanSacnner(String basePackage, String clientName) {
        this.basePackage = basePackage;
        this.clientName = clientName;
    }
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        this.beanFactory = (DefaultListableBeanFactory) beanFactory;
        // 加载远程服务的接口
        List<String> resolverClass = PackageClassUtils.resolver(basePackage);
        for (String clazz : resolverClass) {
            String simpleName;
            if (clazz.lastIndexOf('.') != -1) {
                simpleName = clazz.substring(clazz.lastIndexOf('.') + 1);
            } else {
                simpleName = clazz;
            }
            BeanDefinitionBuilder gd = BeanDefinitionBuilder.genericBeanDefinition(RPCProxyFactoryBean.class);
            gd.addPropertyValue("interfaceClass", clazz);
            gd.addPropertyReference("nettyClient", clientName);
            this.beanFactory.registerBeanDefinition(simpleName, gd.getRawBeanDefinition());
        }
    }
}
