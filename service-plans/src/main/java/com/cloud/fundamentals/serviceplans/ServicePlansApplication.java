package com.cloud.fundamentals.serviceplans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServicePlansApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicePlansApplication.class, args);
	}

}
