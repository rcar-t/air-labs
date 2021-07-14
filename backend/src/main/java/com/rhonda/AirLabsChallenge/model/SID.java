package com.rhonda.AirLabsChallenge.model;

import java.util.List;

public class SID {
	private String name;
	private Airport airport;
	private List<Waypoint> waypoints;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Airport getAirport() {
		return airport;
	}
	public void setAirport(Airport airport) {
		this.airport = airport;
	}
	public List<Waypoint> getWaypoints() {
		return waypoints;
	}
	public void setWaypoints(List<Waypoint> waypoints) {
		this.waypoints = waypoints;
	} 
	
	
}
