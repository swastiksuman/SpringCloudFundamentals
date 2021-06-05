package com.cloud.fundamentals.clientfirst.service;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cloud.fundamentals.clientfirst.model.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class RabbitMQSender {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private AmqpTemplate rabbitTemplate;

	@Value("${service-om.queue}")
	String queueName;

	public String send(Order order) {
		String orderJson;
		try {
			orderJson = objectMapper.writeValueAsString(order);
			Message message = MessageBuilder.withBody(orderJson.getBytes())
					.setContentType(MessageProperties.CONTENT_TYPE_JSON).build();
			rabbitTemplate.convertAndSend("om-exchange", "routingkey", message);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "Send msg = " + order;

	}

	public Map delay(int seconds) {
		Map<String, String> fall = new HashMap<>();
		fall.put("yo", "adrian");
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fall;
	}

	public Supplier<Map> delaySuppplier(int seconds) {
		return () -> this.delay(seconds);
	}
}
