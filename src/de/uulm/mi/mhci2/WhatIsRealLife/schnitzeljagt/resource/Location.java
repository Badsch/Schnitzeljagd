package de.uulm.mi.mhci2.WhatIsRealLife.schnitzeljagt.resource;

import android.graphics.Bitmap;
import android.util.Log;

public class Location {
	
	//GPS Coords
	private double latitude;
	private double longitude;
	private String[] hints;
	private String title;
	private String url;

	private Bitmap thumb;

	
	public Location (double _lat, double _long, String[] _hints, String _title, String _url){
		this.latitude = _lat;
		this.longitude = _long;
		this.hints = _hints;
		this.setTitle(_title);
		this.url = _url;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
    public Bitmap getThumb()
    {
        return thumb;
    }


    public void setThumb(Bitmap thumb)
    {
        this.thumb = thumb;        
        
    }

}
