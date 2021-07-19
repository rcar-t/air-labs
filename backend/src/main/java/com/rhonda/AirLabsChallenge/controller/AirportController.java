package com.rhonda.AirLabsChallenge.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.rhonda.AirLabsChallenge.dto.Response;
import com.rhonda.AirLabsChallenge.dto.Response.Status;
import com.rhonda.AirLabsChallenge.dto.TopWaypoints;
import com.rhonda.AirLabsChallenge.model.Airport;
import com.rhonda.AirLabsChallenge.model.SID;
import com.rhonda.AirLabsChallenge.service.AirportService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AirportController {
	
	@Autowired
	private AirportService airportService; 
	
	@GetMapping("/airports")
	public Response<List<Airport>> getAllAirports() 
			throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		return new Response(Status.HTTP_OK, airportService.getAllAirports());
	}
	
	@GetMapping("/sids/{airportId}")
	public Response<List<SID>> getSidsByAirport(@PathVariable("airportId") String airportId) 
			throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		return new Response(Status.HTTP_OK, airportService.getSidsByAirport(airportId));
	}
	
	@GetMapping("/topWaypoints/sid/{airportId}")
	public Response<TopWaypoints> getTopWaypointsBySids(@PathVariable("airportId") String airportId)
			throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		return new Response(Status.HTTP_OK, airportService.getTopWaypointsBySids(2, airportId));
	}
	
	@GetMapping("/topWaypoints/sid/all")
	public Response<List<TopWaypoints>> getAllTopWaypointsBySids() 
			throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		return new Response(Status.HTTP_OK, airportService.getAllTopWaypointsBySids());
	}
	
	@GetMapping("/topWaypoints/star/{airportId}")
	public Response<TopWaypoints> getTopWaypointsByStars(@PathVariable("airportId") String airportId)
			throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		return new Response(Status.HTTP_OK, airportService.getTopWaypointsByStars(2, airportId));
	}
	
	@GetMapping("/topWaypoints/star/all")
	public Response<List<TopWaypoints>> getAllTopWaypointsByStars() 
			throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		return new Response(Status.HTTP_OK, airportService.getAllTopWaypointsByStars());
	}
}
