package com.practice.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practice.hibernate.util.HibernateUtil;

public class QueryCache {

	public static void main(String[] args) {

		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session session = sessFact.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		Query query=session.createQuery("from UserDetails user where user.userId= 1");
		query.setCacheable(true);
		List users=query.list();
		
		tr.commit();
		sessFact.close();

	}

}
