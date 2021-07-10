package com.cloud.fundamentals.serviceproduct.controller;

import java.time.Duration;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cloud.fundamentals.serviceproduct.dto.FetchUserRequestDto;
import com.cloud.fundamentals.serviceproduct.dto.FetchUserResponseDto;
import com.cloud.fundamentals.serviceproduct.service.UserService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Mono;

@RestController
public class TestController {
	
	@Value("${service.instance.name}")
	private String instanceName;
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value ="Fetch Test Information")
	@GetMapping("/test")
	public Mono<String> doTest() {
		Mono<String> monoStream = Mono.delay(Duration.ofMillis(500)).just("Test Successful for instance+: "+instanceName);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return monoStream;
	}
	
	
	@ApiOperation(value="Add a User")
	@PostMapping("/addUser")
	public String addUser() {
		return "User is added.";
	}
	
	@ApiOperation(value="Remove a User")
	@DeleteMapping("/removeUser/{id}")
	public String removeUser(@PathVariable Integer id) {
		return "User "+id+" is removed.";
	}
	
	@ApiOperation(value="Fetch a User")
	@PostMapping("/fetchUser")
	public FetchUserResponseDto fetchUserId(@RequestBody FetchUserRequestDto fetchUserRequestDto) {
		FetchUserResponseDto fetchUserResponseDto = new FetchUserResponseDto();
		fetchUserResponseDto.setSearchResult(userService.userSearch());
		return fetchUserResponseDto;
	}
}
