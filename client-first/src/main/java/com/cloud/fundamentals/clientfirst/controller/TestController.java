package com.cloud.fundamentals.clientfirst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cloud.fundamentals.clientfirst.dto.FetchUserRequestDto;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class TestController {
	
	@Autowired
	private EurekaClient client;

	@Autowired
	private RestTemplateBuilder restTemplateBuilder;
	
	
	@GetMapping("/")
	public String testClient() {
		RestTemplate restTemplate = restTemplateBuilder.build();
		InstanceInfo instanceInfo = client.getNextServerFromEureka("service-first", false);
		String baseUrl = instanceInfo.getHomePageUrl();
		FetchUserRequestDto fetchUserRequestDto = new FetchUserRequestDto();
		fetchUserRequestDto.setId(321);
		HttpEntity<FetchUserRequestDto> request = new HttpEntity<FetchUserRequestDto>(fetchUserRequestDto);
		ResponseEntity<String> response = restTemplate.exchange(baseUrl+"fetchUser", HttpMethod.POST, request, String.class);
		return response.getBody()+" footer";
	}
	
	@GetMapping("/doTransaction")
	public String transaction() {
		RestTemplate restTemplate = restTemplateBuilder.build();
		InstanceInfo instanceInfo = client.getNextServerFromEureka("service-first", false);
		String baseUrl = instanceInfo.getHomePageUrl();
		FetchUserRequestDto fetchUserRequestDto = new FetchUserRequestDto();
		fetchUserRequestDto.setId(321);
		HttpEntity<FetchUserRequestDto> request = new HttpEntity<FetchUserRequestDto>(fetchUserRequestDto);
		ResponseEntity<String> response = restTemplate.exchange(baseUrl+"fetchUser", HttpMethod.POST, request, String.class);
		ResponseEntity<String> response1 = restTemplate.exchange(baseUrl+"/test", HttpMethod.GET, null, String.class);
		return response.getBody() + response1.getBody() +" footer";
	}
}
