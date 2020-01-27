package com.message;

import java.io.IOException;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

	@KafkaListener(topics="${jsa.kafka.topic}")
    public void handle(String data) {
    	
    	
    		
			System.out.println(" ***** Person ETO ##### ***** " + data);
			
    	
    	
		
	}
	
	
}
