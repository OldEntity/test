package com.lishuo.testwebsocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


/*@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class TestWebsocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestWebsocketApplication.class, args);
    }

}*/


@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class TestWebsocketApplication extends SpringBootServletInitializer {


    private static final Logger logger= LoggerFactory.getLogger(TestWebsocketApplication.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(TestWebsocketApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(TestWebsocketApplication.class, args);
        logger.info("SpringBoot启动完毕！");
    }

}
