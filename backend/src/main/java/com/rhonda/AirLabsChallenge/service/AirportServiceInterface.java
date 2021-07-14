package com.rhonda.AirLabsChallenge.service;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.rhonda.AirLabsChallenge.dto.TopWaypoints;
import com.rhonda.AirLabsChallenge.model.Airport;
import com.rhonda.AirLabsChallenge.model.SID;

public interface AirportServiceInterface {

	List<Airport> getAllAirports() 
			throws JsonParseException, JsonMappingException, IOException, InterruptedException;

	List<SID> getSidsByAirport(String airportId)
			throws JsonParseException, JsonMappingException, IOException, InterruptedException;

	TopWaypoints getTopWaypointsBySids(int top, String airportId)
			throws JsonParseException, JsonMappingException, IOException, InterruptedException;

	List<TopWaypoints> getAllTopWaypointsBySids()
			throws JsonParseException, JsonMappingException, IOException, InterruptedException;

	List<SID> getStarsByAirport(String airportId)
			throws JsonParseException, JsonMappingException, IOException, InterruptedException;

	TopWaypoints getTopWaypointsByStars(int top, String airportId)
			throws JsonParseException, JsonMappingException, IOException, InterruptedException;

	List<TopWaypoints> getAllTopWaypointsByStars()
			throws JsonParseException, JsonMappingException, IOException, InterruptedException;
	
}
