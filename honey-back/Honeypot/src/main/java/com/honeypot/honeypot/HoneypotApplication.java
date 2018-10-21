package com.honeypot.honeypot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.honeypot.honeypot.dao")
public class HoneypotApplication {
	public static void main(String[] args) {
		SpringApplication.run(HoneypotApplication.class, args);

	}

}
