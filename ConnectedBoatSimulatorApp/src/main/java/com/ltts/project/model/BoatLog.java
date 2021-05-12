package com.ltts.project.model;

public class BoatLog {

	
	private String hull_id;
	private String boat_name;
	private String model;
	private Integer noOfEngines;
	
	
	
	
	
	
	
	
	
	
	
	
	public BoatLog(String hull_id, String boat_name, String model, Integer noOfEngines) {
		super();
		this.hull_id = hull_id;
		this.boat_name = boat_name;
		this.model = model;
		this.noOfEngines = noOfEngines;
	}
	public BoatLog() {
		super();
	}
	public String getHull_id() {
		return hull_id;
	}
	public void setHull_id(String hull_id) {
		this.hull_id = hull_id;
	}
	public String getBoat_name() {
		return boat_name;
	}
	public void setBoat_name(String boat_name) {
		this.boat_name = boat_name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getNoOfEngines() {
		return noOfEngines;
	}
	public void setNoOfEngines(Integer noOfEngines) {
		this.noOfEngines = noOfEngines;
	}
	@Override
	public String toString() {
		return "BoatLog [hull_id=" + hull_id + ", boat_name=" + boat_name + ", model=" + model + ", noOfEngines="
				+ noOfEngines + "]";
	}
	

	
}
