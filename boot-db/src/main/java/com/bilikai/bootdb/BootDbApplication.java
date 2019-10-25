package com.bilikai.bootdb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bilikai.boot.accounts.mapper")
public class BootDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootDbApplication.class, args);
	}

}
