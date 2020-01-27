package com.base;

import java.io.Serializable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EventEnvelope implements Serializable{
	
	private String id;
	private String eventName;
	private String eventEto;
	
	public void setEventEto(String baseEto){
		this.eventEto = baseEto;
	}
	
	public void setEventEto(Object baseEto){
		ObjectMapper mapper = new ObjectMapper();
		try {
			eventEto = mapper.writeValueAsString(baseEto);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Error sending ETO");
		}
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventEto() {
		return eventEto;
	}

}