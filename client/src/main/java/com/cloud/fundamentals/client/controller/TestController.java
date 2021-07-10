package com.cloud.fundamentals.client.controller;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cloud.fundamentals.client.dto.FetchUserRequestDto;
import com.cloud.fundamentals.client.model.Order;
import com.cloud.fundamentals.client.model.PlaceOrder;
import com.cloud.fundamentals.client.service.RabbitMQSender;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;

@RestController
public class TestController {
	
	@Autowired
	private EurekaClient client;

	@Autowired
	private RestTemplateBuilder restTemplateBuilder;
	
	@Autowired
	private RabbitMQSender rabbitMQSender;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CircuitBreakerFactory circuitBreakerFactory;
	
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
	
	@GetMapping("/test")
	public String testRibbon() {
		String string = restTemplate.getForObject("http://service-first/test", String.class);
		System.out.println(string);
		return string;
	}
	
	@GetMapping("/delay/{seconds}")
	public Map testcb(@PathVariable int seconds) {
		Map<String, String> fall = new HashMap<>();
		fall.put("hello", "world");
		return circuitBreakerFactory.create("delay")
				.run(rabbitMQSender.delaySuppplier(seconds), t -> {
					System.out.println(t.getMessage());
					Map<String, String> fallback = new HashMap<>();
					fallback.put("hello", "world");
					return fallback;
				});
	}
}
