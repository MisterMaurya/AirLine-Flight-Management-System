package com.airlines.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Flight {

	@Id
	private String flightId;
	private String fromF;
	private String toF;
	private String departTime;
	private String arrivalTime;
	private String departDate;
	private String aircraftName;

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getFromF() {
		return fromF;
	}

	public void setFromF(String fromF) {
		this.fromF = fromF;
	}

	public String getToF() {
		return toF;
	}

	public void setToF(String toF) {
		this.toF = toF;
	}

	public String getDepartTime() {
		return departTime;
	}

	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartDate() {
		return departDate;
	}

	public void setDepartDate(String departDate) {
		this.departDate = departDate;
	}

	public String getAircraftName() {
		return aircraftName;
	}

	public void setAircraftName(String aircraftName) {
		this.aircraftName = aircraftName;
	}

}
