package com.criszheng.rabbitmq.producer;

import org.springframework.stereotype.Component;

import com.criszheng.rabbitmq.config.RabbitConfig;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Cris
 * @date 10 Apr 2021
 * @version 1.0
 */
@Component
public class MsgProducer implements RabbitTemplate.ConfirmCallback {

	private final Logger logger= LoggerFactory.getLogger(this.getClass());
	
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	public MsgProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate=rabbitTemplate;
		rabbitTemplate.setConfirmCallback(this);
	}
	
	public void sendMsg(String content) {
		CorrelationData correlationId =new CorrelationData(UUID.randomUUID().toString());
		rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_A, RabbitConfig.ROUTINGKEY_A, content, correlationId);
	}
	
	public void sendMsgToQueueB(String content) {
		CorrelationData correlationId =new CorrelationData(UUID.randomUUID().toString());
		rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_B, RabbitConfig.ROUTINGKEY_B, content, correlationId);
	}
	
	public void sendAll(String content) {
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(RabbitConfig.FANOUT_EXCHANGE,"", content,correlationId);
    }
	
	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
		// TODO Auto-generated method stub
		logger.info("call back id:"+correlationData);
		if(ack) {
			//logger.info("Message sent to rabbitMQ");
		}else {
			logger.info("Message fail to send to rabbitMQ: "+cause);
		}
	}
	
}
