package com.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.base.EventEnvelope;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MessageProducer {

		
		@Autowired
		private KafkaTemplate<String, String> kafkaTemplate;
		


		/* (non-Javadoc)
		 * @see com.base.domain.MessageProducer#Send(java.lang.Object)
		 */
		@Value("${jsa.kafka.topic}")
		String kafkaTopic;
		
		public void Send(Object event) {
			
			EventEnvelope eventEnvelope = (EventEnvelope) event;
			
			try {
				kafkaTemplate.send(kafkaTopic,eventEnvelope.getId(), new ObjectMapper().writeValueAsString(event));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("Error publishing Domain Event");
			}
		}
		
	}
	
	

