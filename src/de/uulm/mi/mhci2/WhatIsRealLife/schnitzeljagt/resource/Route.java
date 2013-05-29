package de.uulm.mi.mhci2.WhatIsRealLife.schnitzeljagt.resource;

public class Route {
	public static int locCounter = 0;
	
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

}
