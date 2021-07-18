package com.rhonda.AirLabsChallenge.repository;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rhonda.AirLabsChallenge.config.ApiConfig;
import com.rhonda.AirLabsChallenge.model.Airport;
import com.rhonda.AirLabsChallenge.model.SID;

@Component
public class AirportRepository {
	
	private static ApiConfig apiConfig;
	
	private static String url;
	
	private static String apiKey;
	
	@Autowired
	public AirportRepository(ApiConfig apiConfig) {
		AirportRepository.apiConfig = apiConfig;
		AirportRepository.url = apiConfig.getConfigValue("repo.url");
		AirportRepository.apiKey = apiConfig.getConfigValue("repo.api-key");
	}
	
	/* 
	 * Returns a list of all airports 
	 * @return a list of airports 
	 * @see Airport
	 * */
	public List<Airport> getAllAirports() throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		ObjectMapper objectMapper = new ObjectMapper();
		TypeReference<List<Airport>> type = new TypeReference<List<Airport>>(){};
		
		String response = get(String.format("%s/airac/airports", url));
		return (null == response) ? null : objectMapper.readValue(response, type);
	}
	
	public List<SID> getSidsByAirport(String airportId) throws JsonMappingException, JsonProcessingException, IOException, InterruptedException {
		ObjectMapper objectMapper = new ObjectMapper();
		TypeReference<List<SID>> type = new TypeReference<List<SID>>(){};
		
		String response = get(String.format("%s/airac/sids/airport/%s", url, airportId));
		return (null == response) ? null : objectMapper.readValue(response, type);
	}
	
	public List<SID> getStarsByAirport(String airportId) 
			throws JsonMappingException, JsonProcessingException, IOException, InterruptedException {
		ObjectMapper objectMapper = new ObjectMapper();
		TypeReference<List<SID>> type = new TypeReference<List<SID>>(){};
		
		String response = get(String.format("%s/airac/stars/airport/%s", url, airportId));
		return (null == response) ? null : objectMapper.readValue(response, type);
	}
	
	private String get(String uri) throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create(uri))
			.header("api-key", AirportRepository.apiKey)
			.build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		
		return (response.body().contains("<")) ? null : response.body();
	}
}
