package com.airlines.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.airlines.dao.api.AircraftDAO;
import com.airlines.entity.Aircraft;
import com.airlines.util.ConnectWithHibernate;

public class AircarftDAOImpl implements AircraftDAO {
	Session session = null;
	ConnectWithHibernate connect = new ConnectWithHibernate();;

	public boolean saveAircraft(Aircraft aircraft) {
		

		Session session = connect.getSession();
		try {
			session.beginTransaction();
			session.save(aircraft);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		} finally {
			session.close();
		}
		return true;
	}

	public boolean removeAircraft(Aircraft aircraft) {

		return false;
	}

	public List<Aircraft> getAllCarft() {
		Session session = connect.getSession();
		session.beginTransaction();
		List<Aircraft> aircraft  = new ArrayList<Aircraft>();
		aircraft = session.createQuery("from Aircraft").list(); 
		session.getTransaction().commit();
		return aircraft;
	}

	public Aircraft getAircarftById(int aircraftId) {

		return null;
	}

	public Aircraft getAircarftByName(String aircraftName) {

		return null;
	}

	public boolean updateAircarft(Aircraft aircraft) {

		return false;
	}

}
