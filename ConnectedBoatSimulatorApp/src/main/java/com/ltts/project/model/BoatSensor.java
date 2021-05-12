package com.ltts.project.model;

public class BoatSensor {

	private double ocean_depth;
	private String door_sensor;
	public BoatSensor() {
		super();
	}
	public BoatSensor(double ocean_depth, String door_sensor) {
		super();
		this.ocean_depth = ocean_depth;
		this.door_sensor = door_sensor;
	}
	public double getOcean_depth() {
		return ocean_depth;
	}
	public void setOcean_depth(double ocean_depth) {
		this.ocean_depth = ocean_depth;
	}
	public String getDoor_sensor() {
		return door_sensor;
	}
	public void setDoor_sensor(String door_sensor) {
		this.door_sensor = door_sensor;
	}
	@Override
	public String toString() {
		return "BoatSensor [ocean_depth=" + ocean_depth + ", door_sensor=" + door_sensor + "]";
	}
	
	
	
}
