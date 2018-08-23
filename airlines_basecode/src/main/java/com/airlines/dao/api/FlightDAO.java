package com.airlines.dao.api;

import java.util.List;

import com.airlines.entity.Flight;

public interface FlightDAO {
	public boolean saveFlight(Flight flight);
	public boolean updateFlight(Flight flight);
	public List<Flight> search(String whereFrom,String whereTo,String date);
	public List<Flight> getWhereFrom();
	public List<Flight> getWhereTo();
	public List<Flight> getAllFlight();

}
