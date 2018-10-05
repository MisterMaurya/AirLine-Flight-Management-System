package com.airlines.dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import com.airlines.dao.api.FlightDAO;
import com.airlines.entity.Flight;
import com.airlines.util.ConnectWithHibernate;

public class FlightDAOImpl implements FlightDAO {

	Session session = null;
	ConnectWithHibernate connectWithHibernate = new ConnectWithHibernate();

	public boolean saveFlight(Flight flight) {
		try {
			session = connectWithHibernate.getSession();
			session.beginTransaction();
			session.save(flight);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean updateFlight(Flight flight) {

		return false;
	}

	public List<Flight> getAllFlight() {

		return null;
	}

	@Override
	public List<Flight> getWhereFrom() {
		ArrayList<Flight> whereFromList = new ArrayList<>();

		try {
			session = connectWithHibernate.getSession();
			session.beginTransaction();
			whereFromList = (ArrayList<Flight>) session.createQuery("select fromF From Flight").list();
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return whereFromList;

	}

	@Override
	public List<Flight> getWhereTo() {
		ArrayList<Flight> whereToList = new ArrayList<>();

		try {
			session = connectWithHibernate.getSession();
			session.beginTransaction();
			whereToList = (ArrayList<Flight>) session.createQuery("select toF From Flight").list();
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return whereToList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Flight> search(String whereFrom, String whereTo, String date) {
		ArrayList<Flight> search = new ArrayList<>();
		try{
			session = connectWithHibernate.getSession();
			String hql = "From Flight where fromF = :fromF and toF = :toF and departDate=:departDate";
			session.beginTransaction();
			search =(ArrayList<Flight>) session.createQuery(hql)
					.setParameter("fromF",whereFrom)
					.setParameter("toF",whereTo)
					.setParameter("departDate",date)
					.list();
			session.getTransaction().commit();
			session.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return search;
	}

}
