package com.cloud.fundamentals.servicefirst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServiceFirstApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceFirstApplication.class, args);
	}

}
