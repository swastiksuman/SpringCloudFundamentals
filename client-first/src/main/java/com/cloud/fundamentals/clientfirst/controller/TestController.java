package com.cloud.fundamentals.clientfirst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cloud.fundamentals.clientfirst.dto.FetchUserRequestDto;
import com.cloud.fundamentals.clientfirst.model.Order;
import com.cloud.fundamentals.clientfirst.model.PlaceOrder;
import com.cloud.fundamentals.clientfirst.service.RabbitMQSender;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class TestController {
	
	@Autowired
	private EurekaClient client;

	@Autowired
	private RestTemplateBuilder restTemplateBuilder;
	
	@Autowired
	private RabbitMQSender rabbitMQSender;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/")
	public String testClient() {
		RestTemplate restTemplate = restTemplateBuilder.build();
		InstanceInfo instanceInfo = client.getNextServerFromEureka("service-first", false);
		String baseUrl = instanceInfo.getHomePageUrl();
		FetchUserRequestDto fetchUserRequestDto = new FetchUserRequestDto();
		fetchUserRequestDto.setId(321);
		HttpEntity<FetchUserRequestDto> request = new HttpEntity<FetchUserRequestDto>(fetchUserRequestDto);
		ResponseEntity<String> response = restTemplate.exchange(baseUrl+"fetchUser", HttpMethod.POST, request, String.class);
		return response.getBody();
	}
	@CrossOrigin(origins = "http://localhost:3000")
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
	
	@PostMapping(path="/placeOrder", consumes="application/json", produces="application/json")
	@CrossOrigin(origins = "http://localhost:3000")
	public String placeOrder(@RequestBody PlaceOrder placeOrder) {
		Order order = new Order();
		order.setItemId(101);
		order.setFirstName(placeOrder.getFirstName());
		order.setLastName(placeOrder.getLastName());
		order.setOrderId(123123897);
		System.out.println(order.toString());
		return rabbitMQSender.send(order);
	}
}
