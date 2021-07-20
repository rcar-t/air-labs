package com.rhonda.AirLabsChallenge.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.rhonda.AirLabsChallenge.service.AirportService;


@RunWith(SpringRunner.class)
@WebMvcTest(AirportController.class)
public class AirportControllerIntTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private AirportService service;
	
	@Test
	public void getAllAirportsAPI() throws Exception {
		mvc.perform(MockMvcRequestBuilders
				.get("/api/airports")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk());
//				.andExpect(MockMvcResultMatchers.jsonPath("$.body").isNotEmpty());	
	}
	
	@Test
	public void getTopWaypointsBySidAPI() throws Exception {
		mvc.perform(MockMvcRequestBuilders
				.get("/api/topWaypoints/sid/{id}", "WSSS")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk());
//				.andExpect(MockMvcResultMatchers.jsonPath("$.body").isNotEmpty());	
	}
}
