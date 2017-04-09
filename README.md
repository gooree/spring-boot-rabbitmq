# spring-boot-rabbitmq
spring-boot结合RabbitMQ入门示例

# 在maven配置文件中加入spring-boot-starter-amqp依赖
  ```xml
    <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-amqp</artifactId>
		</dependency>
    ```
    
# RabbitmqApplication
  ```java
  @EnableRabbit
  @SpringBootApplication
  public class RabbitmqApplication {

      private static final Logger logger = LoggerFactory.getLogger(RabbitmqApplication.class);

      public static void main(String[] args) throws Exception {
          SpringApplication.run(RabbitmqApplication.class, args);
          logger.info("RabbitmqApplication is starting......>>>>");
      }

  }
  ```
  
# 消息Producer
  ```java
  @Autowired
	private AmqpTemplate amqpTemplate;
  
  public void send(Object msg) {		
		if(msg instanceof String) {
			amqpTemplate.convertAndSend("wxjfkg", "wxjf", (String) msg);
		} else {
			Gson gson = new Gson();
			String message = gson.toJson(msg);
			amqpTemplate.convertAndSend("wxjfkg", "wxjf", message);
		}
	}
  ```
  
# 消息Consumer
  ```java
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
  ```
  
  
