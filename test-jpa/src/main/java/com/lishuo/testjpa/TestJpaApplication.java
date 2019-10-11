package com.lishuo.testjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication
public class TestJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestJpaApplication.class, args);
	}

}
