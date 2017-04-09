package com.wxjfkg.rabbitmq.core;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

	@RabbitListener(bindings = { @QueueBinding(
		exchange = @Exchange(value = "wxjfkg", autoDelete = "false", durable = "true"), 
		value = @Queue(value = "wxjf-queue", durable = "true", autoDelete = "false"),
		key = "wxjf") 
	})
	public void process(String msg) {
		System.out.println("msg: " + msg);
	}

}
