package com.finance.testproject;

import com.finance.testproject.configuration.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppConfig.class, args);
	}
}
