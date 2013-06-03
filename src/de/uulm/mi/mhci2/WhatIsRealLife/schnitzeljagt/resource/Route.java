package de.uulm.mi.mhci2.WhatIsRealLife.schnitzeljagt.resource;

public class Route {
	public static int locCounter = 0;
	
	private String name;
	private String id;
	private Location[] locations;
	private boolean[] isWardSolved;
	
	
	
	
	public Route(int nrOfLocations){
		locations = new Location[nrOfLocations];
		isWardSolved = new boolean[locations.length];
		for(int i = 0; i< locations.length; i++){
			isWardSolved[i] = false;
		}
	}
	
	public static Route initDefault(){
		return new Route(5);
	}
	
	public Location getCurrendLocation(){
		return locations[locCounter];
	}
	
	public void addLocation(Location loc, int pos){
		locations[pos] = loc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
