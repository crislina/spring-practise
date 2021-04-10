package com.criszheng.rabbitmq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.criszheng.rabbitmq.config.RabbitConfig;

/**
 * @author Cris
 * @date 10 Apr 2021
 * @version 1.0
 */

@Component
@RabbitListener(queues=RabbitConfig.QUEUE_B)
public class MsgReceiverB_C {
	
	private final Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@RabbitHandler
	public void process(String content) {
		logger.info("Processer C is processing info from Queue B:{}", content);
	}
}
