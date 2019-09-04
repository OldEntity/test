package com.lishuo.testwebserviceserver.config;

import com.lishuo.testwebserviceserver.server.DemoService;
import com.lishuo.testwebserviceserver.server.impl.DemoServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.cxf.jaxws.EndpointImpl;

import javax.xml.ws.Endpoint;
/**
 * @Program：test
 * @Description：
 * @Author：LearnLi
 * @Create:2019-09-04 14:47
 */

@Configuration
public class WebServiceConfig {
    /**
     * 注入servlet  bean name不能dispatcherServlet 否则会覆盖dispatcherServlet
     * @return
     */
    @Bean(name = "cxfServlet")
    public ServletRegistrationBean cxfServlet() {
        return new ServletRegistrationBean(new CXFServlet(),"/demo/*");

    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }


    @Bean
    public DemoService getDemoServiceImpl(){
        return new DemoServiceImpl();
    }

    /**
     * 注册WebServiceDemoService接口到webservice服务
     * @return
     */
    @Bean(name = "DemoEndpoint")
    public Endpoint sweptPayEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), getDemoServiceImpl());
        endpoint.publish("/api");
        return endpoint;
    }




}
