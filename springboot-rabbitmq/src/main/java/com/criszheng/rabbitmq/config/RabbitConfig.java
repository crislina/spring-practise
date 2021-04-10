package com.criszheng.rabbitmq.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


/**
 * @author Cris
 * @date 7 Apr 2021
 * @version 1.0
 */

@Configuration
public class RabbitConfig {
	
	private final Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Value("${spring.rabbitmq.host}")
	private String host;
	
	@Value("${spring.rabbitmq.port}")
	private int port;
	
	@Value("${spring.rabbitmq.username}")
	private String username;
	
	@Value("${spring.rabbitmq.password}")
	private String password;
	
	public static final String EXCHANGE_A="my-mq-exchange_A";
	public static final String EXCHANGE_B="my-mq-exchange_B";
	public static final String EXCHANGE_C="my-mq-exchange_C";
	public static final String FANOUT_EXCHANGE = "my-mq-fanout_exchange";
	
	public static final String QUEUE_A="QUEUE_A";
	public static final String QUEUE_B="QUEUE_B";
	public static final String QUEUE_C="QUEUE_C";
	
	public static final String ROUTINGKEY_A="Spring-boot-routingKey_A";
	public static final String ROUTINGKEY_B="Spring-boot-routingKey_B";
	public static final String ROUTINGKEY_C="Spring-boot-routingKey_C";
	
	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host,port);
		connectionFactory.setUsername(username);
		connectionFactory.setPassword(password);
		connectionFactory.setVirtualHost("/");
		connectionFactory.setPublisherConfirms(true);
		return connectionFactory;
	}
	
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate template = new RabbitTemplate(connectionFactory());
		return template;
	}

	@Bean
	public DirectExchange defaultExchange() {
		return new DirectExchange(EXCHANGE_A);
	}
	
	@Bean
	public DirectExchange exchangeB() {
		return new DirectExchange(EXCHANGE_B);
	}
	
	@Bean
	public Queue queueA() {
		return new Queue(QUEUE_A,true);
	}
	
	@Bean
	public Queue queueB() {
		return new Queue(QUEUE_B,true);
	}
	
	@Bean
	public Queue queueC() {
		return new Queue(QUEUE_C,true);
	}
	
	@Bean
	public Binding binding() {
		return BindingBuilder.bind(queueA()).to(defaultExchange()).with(ROUTINGKEY_A);
	}
	
	@Bean
	public Binding bindingB() {
		return BindingBuilder.bind(queueB()).to(exchangeB()).with(ROUTINGKEY_B);
	}
	
	@Bean
	FanoutExchange fanoutExchange() {
		return new FanoutExchange(RabbitConfig.FANOUT_EXCHANGE);
	}
	
	@Bean
    Binding bindingExchangeA(Queue queueA,FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueA).to(fanoutExchange);
    }
    @Bean
    Binding bindingExchangeB(Queue queueB, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueB).to(fanoutExchange);
    }
    @Bean
    Binding bindingExchangeC(Queue queueC, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueC).to(fanoutExchange);
    }
}



