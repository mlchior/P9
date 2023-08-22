package com.medApp.analyzerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AnalyzerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnalyzerServiceApplication.class, args);
	}

}
