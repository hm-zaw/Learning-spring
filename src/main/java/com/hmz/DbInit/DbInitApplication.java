package com.hmz.DbInit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})

public class DbInitApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbInitApplication.class, args);
	}

}
