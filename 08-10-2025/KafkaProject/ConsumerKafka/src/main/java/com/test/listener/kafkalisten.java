package com.test.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class kafkalisten {
	@KafkaListener(topics="new-topic",groupId="My-Group")
	public void mess(String msg)
	{
		System.out.println(msg);
	}

}
