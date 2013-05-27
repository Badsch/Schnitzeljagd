package de.uulm.mi.mhci2.WhatIsRealLife.schnitzeljagt.resource;

public class Location {
	
	//GPS Coords
	private double latitude;
	private double longitude;
	private String[] hints;
	private String title;
	
	public Location (double _lat, double _long, String[] _hints, String _title){
		this.latitude = _lat;
		this.longitude = _long;
		this.hints = _hints;
		this.setTitle(_title);
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String[] getHints() {
		return hints;
	}

	public void setHints(String[] hints) {
		this.hints = hints;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
