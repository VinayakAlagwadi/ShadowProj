package com.ltts.project.model;


public class BoatEngine {
	
	private String hull_id;
	private int engine_id;
	private double engine_rpm;
	private double oil_pressure;
	private double oil_temperature;
	private double engine_temp;
	private double engine_runtime;
	private double engine_fuel_rate;
	
	
	public BoatEngine() {
		super();
	}
	
	public BoatEngine(String hull_id,int engine_id, double engine_rpm, double oil_pressure, double oil_temperature, double engine_temp,
			double engine_runtime, double engine_fuel_rate) {
		super();
		this.hull_id = hull_id;
		this.engine_id = engine_id;
		this.engine_rpm = engine_rpm;
		this.oil_pressure = oil_pressure;
		this.oil_temperature = oil_temperature;
		this.engine_temp = engine_temp;
		this.engine_runtime = engine_runtime;
		this.engine_fuel_rate = engine_fuel_rate;
	}
	
	public int getEngine_id() {
		return engine_id;
	}
	public void setEngine_id(int engine_id) {
		this.engine_id = engine_id;
	}
	public double getEngine_rpm() {
		return engine_rpm;
	}
	public void setEngine_rpm(double engine_rpm) {
		this.engine_rpm = engine_rpm;
	}
	public double getOil_pressure() {
		return oil_pressure;
	}
	public void setOil_pressure(double oil_pressure) {
		this.oil_pressure = oil_pressure;
	}
	public double getOil_temperature() {
		return oil_temperature;
	}
	public void setOil_temperature(double oil_temperature) {
		this.oil_temperature = oil_temperature;
	}
	public double getEngine_temp() {
		return engine_temp;
	}
	public void setEngine_temp(double engine_temp) {
		this.engine_temp = engine_temp;
	}
	public double getEngine_runtime() {
		return engine_runtime;
	}
	public void setEngine_runtime(double engine_runtime) {
		this.engine_runtime = engine_runtime;
	}
	public double getEngine_fuel_rate() {
		return engine_fuel_rate;
	}
	public void setEngine_fuel_rate(double engine_fuel_rate) {
		this.engine_fuel_rate = engine_fuel_rate;
	}
	
	
	
	
	
	

	@Override
	public String toString() {
		return "BoatEngine [hull_id=" + hull_id + ", engine_id=" + engine_id + ", engine_rpm=" + engine_rpm
				+ ", oil_pressure=" + oil_pressure + ", oil_temperature=" + oil_temperature + ", engine_temp="
				+ engine_temp + ", engine_runtime=" + engine_runtime + ", engine_fuel_rate=" + engine_fuel_rate + "]";
	}

	public String getHull_id() {
		return hull_id;
	}

	public void setHull_id(String hull_id) {
		this.hull_id = hull_id;
	}
	
	
	
	

}
