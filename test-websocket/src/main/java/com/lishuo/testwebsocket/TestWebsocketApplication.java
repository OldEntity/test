package com.lishuo.testwebsocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class TestWebsocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestWebsocketApplication.class, args);
    }

}
