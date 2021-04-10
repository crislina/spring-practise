package com.criszheng.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.criszheng.rabbitmq.producer.MsgProducer;

/**
 * @author Cris
 * @date 10 Apr 2021
 * @version 1.0
 */

@RestController
@RequestMapping("/rabbitmq")
public class RabbitController {

	@Autowired
	private MsgProducer msgProducer;
	
	@RequestMapping(value = "/sendmsg", method = RequestMethod.GET)
	public String sendMsg() {
		int msgNum=10;
		for(int i=0;i<msgNum;i++) {
			msgProducer.sendMsg("This is number "+i+" msg");
		}
		return "success";
	}
	
	@RequestMapping(value = "/sendToQueueB", method = RequestMethod.GET)
	public String sendToQueueB() {
		int msgNum=30;
		for(int i=0;i<msgNum;i++) {
			msgProducer.sendMsgToQueueB("This is number "+i+" msg");
		}
		return "success";
	}

	@RequestMapping(value = "/annouce", method = RequestMethod.GET)
	public String annouce() {
		int msgNum=10;
		for(int i=0;i<msgNum;i++) {
			msgProducer.sendAll("This is annoucement "+i+" msg");
		}
		return "success";
	}
}
