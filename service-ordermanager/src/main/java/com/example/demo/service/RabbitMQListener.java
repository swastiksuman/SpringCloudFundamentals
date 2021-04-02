package com.example.demo.service;

import java.util.concurrent.CountDownLatch;

import org.springframework.stereotype.Component;

import com.example.demo.model.Order;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Component
public class RabbitMQListener{

	@RabbitListener(queues = "${service-om.queue}")
	public void recievedMessage(Message message) {
		System.out.println("Recieved Message From RabbitMQ: " + new String(message.getBody()) );
	}

}