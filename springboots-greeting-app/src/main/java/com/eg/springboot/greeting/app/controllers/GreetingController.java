package com.eg.springboot.greeting.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eg.springboot.greeting.app.services.IGreeting;
import com.eg.springboot.greeting.app.models.Greeting;

@RestController
@RequestMapping("/")
public class GreetingController {

	@Autowired
	private IGreeting greetingInstance;

	@GetMapping("/greeting")
	public String greeting(@RequestParam(value = "account", required = false) String account,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "userId", defaultValue = "0", required = false) String userId, Model model) {
		String returnMessage = "";
		int id = 0;
		try {
			id = Integer.parseInt(userId);
			returnMessage = greetingInstance.getGreeting(new Greeting(account, type, id));
		} catch (NumberFormatException e) {
			returnMessage = "Only numbers are allowed in the userId attribute.";
		}
		return returnMessage;
	}

}
