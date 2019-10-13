package com.eg.springboot.greeting.app;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.eg.springboot.greeting.app.controllers.GreetingController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootsGreetingAppApplicationTests {

	@Autowired
	private GreetingController controllerInstance;

	@Test
	public void getGreetingForBigBusiness() {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controllerInstance).build();
		  String response = "";
		try {
			response = mockMvc.perform(get("/greeting?account=business&type=big")).andExpect(status().isOk())
			  .andReturn().getResponse().getContentAsString();
			  assertEquals("Welcome, business user!", response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@Test
	public void getGreetingForSmallBusiness(){
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controllerInstance).build();
		  String response = "";
		try {
			response = mockMvc.perform(get("/greeting?account=business&type=small")).andExpect(status().isOk())
			  .andReturn().getResponse().getContentAsString();
			  assertEquals("The path is not yet implemented.", response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void getGreetingForPersonal(){
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controllerInstance).build();
		  String response = "";
		  String userId = "";
		try {
			response = mockMvc.perform(get("/greeting?account=personal&userId=123")).andExpect(status().isOk())
			  .andReturn().getResponse().getContentAsString();
			 userId =  mockMvc.perform(get("/greeting?account=personal&userId=123")).andReturn().getRequest().getParameter("userId"); 
			 assertEquals("Hi, userId: "+userId, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	}
	
	@Test
	public void catchGreetingException(){
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controllerInstance).build();
		  String response = "";
		try {
			response = mockMvc.perform(get("/greeting?account=personal&userId=asd")).andExpect(status().isOk())
			  .andReturn().getResponse().getContentAsString();
			  assertEquals("Only numbers are allowed in the userId parameter.", response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
