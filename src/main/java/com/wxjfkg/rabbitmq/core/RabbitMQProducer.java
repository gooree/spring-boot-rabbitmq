package com.wxjfkg.rabbitmq.core;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class RabbitMQProducer {

//	@Autowired
//	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	public static final String EXCHANGE   = "spring-boot-exchange";  
    public static final String ROUTINGKEY = "spring-boot-routingKey";
	
	public void send(Object msg) {
//		rabbitTemplate.convertAndSend(EXCHANGE, ROUTINGKEY, msg);
		
//		MessagePostProcessor processor = new MessagePostProcessor() {
//			@Override
//			public Message postProcessMessage(Message message)
//					throws AmqpException {
//				MessageProperties properties = message.getMessageProperties();
//				properties.setDeliveryMode(MessageDeliveryMode.PERSISTENT);
//				return message;
//			}
//		};
		
		if(msg instanceof String) {
			amqpTemplate.convertAndSend("wxjfkg", "wxjf", (String) msg);
		} else {
			Gson gson = new Gson();
			String message = gson.toJson(msg);
			amqpTemplate.convertAndSend("wxjfkg", "wxjf", message);
		}
	}
	
}
