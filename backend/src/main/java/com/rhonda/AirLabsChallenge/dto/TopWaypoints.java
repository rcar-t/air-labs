package com.rhonda.AirLabsChallenge.dto;

import java.util.List;

public class TopWaypoints {
	private String airport;
	private List<WaypointCount> topWaypoints;
	
	public TopWaypoints() {
		super();
	}
	
	public TopWaypoints(String airport, List<WaypointCount> topWaypoints) {
		super();
		this.airport = airport;
		this.topWaypoints = topWaypoints;
	}

	public String getAirport() {
		return airport;
	}
	
	public void setAirport(String airport) {
		this.airport = airport;
	}

	public List<WaypointCount> getTopWaypoints() {
		return topWaypoints;
	}

	public void setTopWaypoints(List<WaypointCount> topWaypoints) {
		this.topWaypoints = topWaypoints;
	}
}
