package com.ltts.project.model;

public class BoatLocation {
	
	private String hull_id;
	private double latitude;
	private double longitude;
	private double heading;
	private Double altitude;
	private String timestamp;

	
	
	
	public BoatLocation() {
		super();
	}




	public BoatLocation(String hull_id, double latitude, double longitude, double heading, Double altitude,
			String timestamp) {
		super();
		this.hull_id = hull_id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.heading = heading;
		this.altitude = altitude;
		this.timestamp = timestamp;
	}




	public String getHull_id() {
		return hull_id;
	}




	public void setHull_id(String hull_id) {
		this.hull_id = hull_id;
	}




	public Double getLatitude() {
		return latitude;
	}




	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}




	public Double getLongitude() {
		return longitude;
	}




	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}




	public Double getHeading() {
		return heading;
	}




	public void setHeading(Double heading) {
		this.heading = heading;
	}




	public Double getAltitude() {
		return altitude;
	}




	public void setAltitude(Double double1) {
		this.altitude = double1;
	}




	public String getTimestamp() {
		return timestamp;
	}




	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}




	@Override
	public String toString() {
		return "BoatLocation [hull_id=" + hull_id + ", latitude=" + latitude + ", longitude=" + longitude + ", heading="
				+ heading + ", altitude=" + altitude + ", timestamp=" + timestamp + "]";
	}



	
	

}
