package com.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Inventory")
public class KafkaController {
	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;

//	
//	@Value("${inventory}")
//	private String InventoryTopic;
	
	@PostMapping("/create")
	public String createInventory(@RequestBody String OrderDetails) {
		kafkaTemplate.send("InventoryTopic",OrderDetails);
		return "Order placed successfully";
	}
}
