package com.taowd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @@author taowd
 */
@SpringBootApplication
@MapperScan("com.taowd.module.mapper")
public class HellovueServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(HellovueServiceApplication.class, args);
	}

}
