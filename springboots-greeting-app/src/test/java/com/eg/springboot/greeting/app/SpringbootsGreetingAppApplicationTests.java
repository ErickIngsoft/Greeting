package com.eg.springboot.greeting.app;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eg.springboot.greeting.app.controllers.GreetingController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootsGreetingAppApplicationTests {



	@Autowired
	private GreetingController controllerInstance;

	@Test
	public void getGreetingForBigBusiness() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controllerInstance).build();
		  String response = mockMvc.perform(get("/greeting?account=business&type=big")).andExpect(status().isOk())
		  .andReturn().getResponse().getContentAsString();
		  assertEquals("Welcome, business user!", response);
	}

	
	@Test
	public void getGreetingForSmallBusiness() throws UnsupportedEncodingException, Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controllerInstance).build();
		  String response = mockMvc.perform(get("/greeting?account=business&type=small")).andExpect(status().isOk())
		  .andReturn().getResponse().getContentAsString();
		  assertEquals("The path is not yet implemented.", response);
	}

	@Test
	public void getGreetingForPersonal() throws UnsupportedEncodingException, Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controllerInstance).build();
		  String response = mockMvc.perform(get("/greeting?account=personal&userId=123")).andExpect(status().isOk())
		  .andReturn().getResponse().getContentAsString();
		  String userId =  mockMvc.perform(get("/greeting?account=personal&userId=123")).andReturn().getRequest().getParameter("userId"); 
		  assertEquals("Hi, userId: "+userId, response);
	}
}
