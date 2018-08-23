package com.airlines.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectWithHibernate {
	public Session getSession() {
		SessionFactory sessionFactory = new Configuration().configure("com/airlines/model/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		return session;
}
}