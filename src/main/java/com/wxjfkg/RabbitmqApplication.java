package com.wxjfkg;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@EnableRabbit
@SpringBootApplication
public class RabbitmqApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(RabbitmqApplication.class);
	
	@Bean
    public CountDownLatch closeLatch() {
        return new CountDownLatch(1);
    }
    
    public static void main(String[] args) throws Exception {
        //启动Spring Boot项目的唯一入口
        ApplicationContext ctx = SpringApplication.run(RabbitmqApplication.class, args);
        logger.info("RabbitmqApplication is starting......>>>>");

        CountDownLatch closeLatch = ctx.getBean(CountDownLatch.class);
        closeLatch.await();
    }

}
