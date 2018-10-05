package com.airlines.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Aircraft {

	@Id
	private String aircraftId;
	private String aircraftName;
	private int seatInFirstClass;
	private int seatInBusinessClass;
	private int seatInEconomyClass;
	private int seatInPremiumEconomyClass;

	public String getAircraftId() {
		return aircraftId;
	}

	public void setAircraftId(String aircraftId) {
		this.aircraftId = aircraftId;
	}

	public String getAircraftName() {
		return aircraftName;
	}

	public void setAircraftName(String aircraftName) {
		this.aircraftName = aircraftName;
	}

	public int getSeatInFirstClass() {
		return seatInFirstClass;
	}

	public void setSeatInFirstClass(int seatInFirstClass) {
		this.seatInFirstClass = seatInFirstClass;
	}

	public int getSeatInBusinessClass() {
		return seatInBusinessClass;
	}

	public void setSeatInBusinessClass(int seatInBusinessClass) {
		this.seatInBusinessClass = seatInBusinessClass;
	}

	public int getSeatInEconomyClass() {
		return seatInEconomyClass;
	}

	public void setSeatInEconomyClass(int seatInEconomyClass) {
		this.seatInEconomyClass = seatInEconomyClass;
	}

	public int getSeatInPremiumEconomyClass() {
		return seatInPremiumEconomyClass;
	}

	public void setSeatInPremiumEconomyClass(int seatInPremiumEconomyClass) {
		this.seatInPremiumEconomyClass = seatInPremiumEconomyClass;
	}

}
