package com.rhonda.AirLabsChallenge.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.rhonda.AirLabsChallenge.dto.TopWaypoints;
import com.rhonda.AirLabsChallenge.dto.WaypointCount;
import com.rhonda.AirLabsChallenge.exception.EntityNotFoundException;
import com.rhonda.AirLabsChallenge.model.Airport;
import com.rhonda.AirLabsChallenge.model.SID;
import com.rhonda.AirLabsChallenge.model.Waypoint;
import com.rhonda.AirLabsChallenge.repository.AirportRepository;

@Component
public class AirportService implements AirportServiceInterface{
	
	@Autowired
	private AirportRepository airportRepository;
	
	Logger logger = LoggerFactory.getLogger(AirportService.class);
	
	@Override
	public List<Airport> getAllAirports() 
			throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		
		List<Airport> airportList = airportRepository.getAllAirports();
		
		if (null != airportList && airportList.size() > 0) {
			return airportList;
		} else {
			logger.error("Airport List cannot be retrieved");
			throw new EntityNotFoundException("Airport List cannot be retrieved");
		}
	}
	
	@Override
	public List<SID> getSidsByAirport(String airportId) 
			throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		List<SID> sidList = airportRepository.getSidsByAirport(airportId);
		
		if (null != sidList && sidList.size() > 0) {
			return sidList;
		} else {
			logger.error("SID List cannot be retrieved for airport id: " + airportId);
			throw new EntityNotFoundException("SID List cannot be retrieved for airport id: " + airportId);
		}
	}
	
	@Override
	public List<SID> getStarsByAirport(String airportId) 
			throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		List<SID> starList = airportRepository.getStarsByAirport(airportId);
		
		if (null != starList && starList.size() > 0) {
			return starList;
		} else {
			logger.error("STAR List cannot be retrieved for airport id: " + airportId);
			throw new EntityNotFoundException("STAR List cannot be retrieved for airport id: " + airportId);
		}
	}
	
	@Override
	public List<TopWaypoints> getAllTopWaypointsBySids() 
			throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		List<TopWaypoints> list = new ArrayList<TopWaypoints>();
		
		List<String> airportIdList = getAirportIdList();
		for (String id: airportIdList) {
			TopWaypoints topWaypoint = getTopWaypointsBySids(2, id);
			list.add(topWaypoint);
		}
		
		return list;
	}
	
	@Override 
	public TopWaypoints getTopWaypointsBySids(int top, String airportId) 
			throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		List<SID> sidList = getSidsByAirport(airportId);
		TopWaypoints topWaypoints = getTopWaypoints(sidList, top, airportId);
		
		return topWaypoints;
	}
	
	@Override
	public List<TopWaypoints> getAllTopWaypointsByStars() 
			throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		List<TopWaypoints> list = new ArrayList<TopWaypoints>();
		
		List<String> airportIdList = getAirportIdList();
		for (String id: airportIdList) {
			TopWaypoints topWaypoint = getTopWaypointsByStars(2, id);
			list.add(topWaypoint);
		}
		
		return list;
	}
	
	@Override public TopWaypoints getTopWaypointsByStars(int top, String airportId) 
			throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		List<SID> starLst = getStarsByAirport(airportId);
		TopWaypoints topWaypoints = getTopWaypoints(starLst, top, airportId);
		
		return topWaypoints;
	}
	
	private List<String> getAirportIdList() 
			throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		return getAllAirports()
				.stream()
				.filter(airport -> Objects.nonNull(airport.getUid()))
				.map(airport -> airport.getUid())
				.collect(Collectors.toList());
	}
	
	private TopWaypoints getTopWaypoints(List<SID> list, int top, String airportId) 
			throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		int count = 0;
		TopWaypoints topWaypoints = new TopWaypoints();
		List<WaypointCount> waypointLst = new ArrayList<WaypointCount>();
		
		Map<String, Integer> waypointSidMap = sortMapByValue(getWaypointSidMap(list, airportId));
		
		for (String waypointName: waypointSidMap.keySet()) {
			if (count++ < top) {
				WaypointCount wpc = new WaypointCount(waypointName, waypointSidMap.get(waypointName));
				waypointLst.add(wpc);
			}
		}
		
		topWaypoints.setAirport(airportId);
		topWaypoints.setTopWaypoints(waypointLst);
		
		return topWaypoints;
	}
	
	private Map<String, Integer> getWaypointSidMap(List<SID> list, String airportId) 
			throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (SID sid: list) {
			List<Waypoint> waypointLst = sid.getWaypoints();
			for (Waypoint waypoint: waypointLst) {
				if (map.containsKey(waypoint.getName())) {
					map.replace(waypoint.getName(), map.get(waypoint.getName()) + 1);
				} else {
					map.put(waypoint.getName(), 1);
				}
			}
		}
		return map;
	}
	
	private Map<String,Integer> sortMapByValue(Map<String,Integer> unsorted) {
		LinkedHashMap<String,Integer> sorted = new LinkedHashMap<>();
		unsorted.entrySet()
			.stream()
			.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
			.forEachOrdered(x -> sorted.put(x.getKey(), x.getValue()));
		return sorted;
	}
}
