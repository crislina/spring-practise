package com.criszheng.rabbitmq.consumer;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.criszheng.rabbitmq.config.RabbitConfig;
import com.rabbitmq.client.Channel;

/**
 * @author Cris
 * @date 8 Apr 2021
 * @version 1.0
 */

@Component
@RabbitListener(queues = RabbitConfig.QUEUE_A)
public class MsgReceiver {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RabbitHandler
	public void process(String content,Channel channel,Message message) {
		logger.info("Processing info from Queue A:{}", content);
		try {
			channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
