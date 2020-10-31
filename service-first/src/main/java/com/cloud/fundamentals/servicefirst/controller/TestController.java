package com.cloud.fundamentals.servicefirst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class TestController {
	
	@Value("${service.instance.name}")
	private String instanceName;
	
	@GetMapping("/")
	public String doTest() {
		return "Test Successful for instance: "+ instanceName;
	}
}
