package com.elevator.simulator.controller;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class SimulatorRestControllerTest {

	public static final String SERVER_URI = "http://localhost:8080/elevator-simulator";
	

	/**
	 * The  servlet container should be up and runing to be able to execute the rest call
	 * 
	 */
   @Test
	public void getData() {
		RestTemplate restTemplate = new RestTemplate();
		String msg = restTemplate.getForObject(SERVER_URI+ "/getData", String.class);
	    Assert.assertEquals("Elevator Simulator Started", msg);
	}
}
