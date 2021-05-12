package com.ltts.project.model;


public class BoatEssentials  {

	
	private String hull_Id;
	private int noofEngines;
	private String status;
	private String startTime;
	
	
	
	private String boat_Speed;
	private String latitude;
	private String longitude;
	
	public BoatEssentials(String hull_Id, int noofEngines, String status, String startTime, String boat_Speed,
			String latitude, String longitude) {
		super();
		this.hull_Id = hull_Id;
		this.noofEngines = noofEngines;
		this.status = status;
		this.startTime = startTime;
		this.boat_Speed = boat_Speed;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public BoatEssentials() {
		super();
	}

	public String getHull_Id() {
		return hull_Id;
	}

	public void setHull_Id(String hull_Id) {
		this.hull_Id = hull_Id;
	}

	public int getNoofEngines() {
		return noofEngines;
	}

	public void setNoofEngines(int noofEngines) {
		this.noofEngines = noofEngines;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getBoat_Speed() {
		return boat_Speed;
	}

	public void setBoat_Speed(String boat_Speed) {
		this.boat_Speed = boat_Speed;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "BoatEssentials [hull_Id=" + hull_Id + ", noofEngines=" + noofEngines + ", status=" + status
				+ ", startTime=" + startTime + ", boat_Speed=" + boat_Speed + ", latitude=" + latitude + ", longitude="
				+ longitude + "]";
	}
	
	
	
	
	}
