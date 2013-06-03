package de.uulm.mi.mhci2.WhatIsRealLife.schnitzeljagt.resource;

public class Location {
	
	//GPS Coords
	private long latitude;
	private long longitude;
	private String[] hints;
	private String title;
	private String url;
	
	public Location (long _lat, long _long, String[] _hints, String _title, String _url){
		this.latitude = _lat;
		this.longitude = _long;
		this.hints = _hints;
		this.setTitle(_title);
		this.url = _url;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(long longitude) {
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
