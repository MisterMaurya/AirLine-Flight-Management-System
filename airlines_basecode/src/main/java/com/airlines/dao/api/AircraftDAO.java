package com.airlines.dao.api;

import java.util.List;

import com.airlines.entity.Aircraft;

public interface AircraftDAO {

	public boolean saveAircraft(Aircraft aircraft);

	public boolean removeAircraft(Aircraft aircraft);

	public List<Aircraft> getAllCarft();

	public Aircraft getAircarftById(int aircraftId);

	public Aircraft getAircarftByName(String aircraftName);

	public boolean updateAircarft(Aircraft aircraft);

}
