package com.cloud.fundamentals.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class RabbitMQConfig {
	@Value("${service-om.queue}")
	String queueName;

	@Bean
	Queue queue() {
		return new Queue(queueName, false);
	}

	/*
	 * @Bean public MessageConverter jsonMessageConverter() { return new
	 * Jackson2JsonMessageConverter(); }
	 * 
	 * @Bean public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory)
	 * { final RabbitTemplate rabbitTemplate = new
	 * RabbitTemplate(connectionFactory);
	 * rabbitTemplate.setMessageConverter(jsonMessageConverter()); return
	 * rabbitTemplate; }
	 */
}
