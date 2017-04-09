package com.wxjfkg.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wxjfkg.RabbitmqApplication;
import com.wxjfkg.rabbitmq.core.RabbitMQProducer;
import com.wxjfkg.rabbitmq.core.RabbitMessage;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RabbitmqApplication.class)
public class RabbitmqTest {
	
	@Autowired
	private RabbitMQProducer producer;

	@Test
	public void testSendMsg() {
		RabbitMessage msg = new RabbitMessage();
		msg.setSubject("Welcome");
		msg.setContent("Hello world!");
		
		producer.send(msg);
	}
}
