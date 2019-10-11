package com.eg.springboot.greeting.app.services;

import org.springframework.stereotype.Service;

import com.eg.springboot.greeting.app.models.Greeting;

@Service
public class GreetingService implements IGreeting {

	@Override
	public String getGreeting(Greeting greeting) {
		String returnMessage = "";
			if (greeting.getUserId() > 0 && "personal".equals(greeting.getAccount())) {
				returnMessage = "Hi, userId: " + greeting.getUserId();
			} else if ("business".equals(greeting.getAccount()) && "big".equals(greeting.getType() )) {
				returnMessage = "Welcome, business user!";
			} else {
				returnMessage = "The path is not yet implemented.";
			}
		return returnMessage;
	}
	
	

}
