package com.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message/")
public class producerController {
@Autowired
private KafkaTemplate<String, String> kfk;
 @PostMapping("/kafka")
 public String kafkamert(@RequestBody String str)
 {
	 kfk.send("new-topic",str);
	 return "Message Sent";
 }
 
}
