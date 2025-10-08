package com.Listner.List;



import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListner {
 @KafkaListener(topics="InventoryTopic", groupId = "my-consumer-group")
  void listen(String message)
  {
	  System.out.println(message);
  }
}