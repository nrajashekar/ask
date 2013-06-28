package com.mapmylocation.dao;

public class RegisterDeviceRequest {
	
	private String name;
	private String deviceId;
	
	public void setName( String name ) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDeviceId( String deviceId ) {
		this.deviceId = deviceId;
	}
	
	public String getDeviceId() {
		return deviceId;
	}

}
