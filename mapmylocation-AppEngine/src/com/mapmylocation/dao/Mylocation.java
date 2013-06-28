package com.mapmylocation.dao;

public class Mylocation {
	
	private String _latitude;
	private String _longitude;
	
	private String str = "S";
	
	public void setLatitude(String latitude){
		_latitude = latitude;
	}
	
	public String getLatitude() {
		return _latitude;	
	}
	
	public void setLongitude(String longitude){
		_longitude = longitude;
	}
	
	public String getLongitude() {
		return _longitude;	
	}

}
