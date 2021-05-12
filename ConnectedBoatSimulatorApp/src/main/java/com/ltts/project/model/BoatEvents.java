package com.ltts.project.model;


public class BoatEvents {
	
	
	private String hull_id;
	private boolean idle;
	private double speed;
	private String timestamp;
	public BoatEvents(String hull_id, boolean idle, double speed, String timestamp) {
		super();
		this.hull_id = hull_id;
		this.idle = idle;
		this.speed = speed;
		this.timestamp = timestamp;
	}
	public BoatEvents() {
		super();
	}
	public String getHull_id() {
		return hull_id;
	}
	public void setHull_id(String hull_id) {
		this.hull_id = hull_id;
	}
	public boolean isIdle() {
		return idle;
	}
	public void setIdle(boolean idle) {
		this.idle = idle;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "BoatEvents [hull_id=" + hull_id + ", idle=" + idle + ", speed=" + speed + ", timestamp=" + timestamp
				+ "]";
	}

	
	
	

}
