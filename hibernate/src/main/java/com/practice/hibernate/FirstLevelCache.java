package com.practice.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practice.hibernate.model.UserDetails;
import com.practice.hibernate.util.HibernateUtil;

public class FirstLevelCache {

	public static void main(String[] args) {

		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session session = sessFact.getCurrentSession();
		Transaction tr = session.beginTransaction();
	
//		UserDetails details=new UserDetails();
//		details.setUserId(1);
//		details.setUserName("Dhrumil");
//		details.setJoinedDate(new Date());
//		session.save(details);
		
		UserDetails user1=(UserDetails)session.get(UserDetails.class, 1);
		
		user1.setAddress("USA");
		user1.setDescription("USA");
		
		UserDetails user2=(UserDetails)session.get(UserDetails.class, 1);
		
		tr.commit();
		
		Session session2 = sessFact.getCurrentSession();
		Transaction tr2 = session2.beginTransaction();
		
		UserDetails user3=(UserDetails)session2.get(UserDetails.class, 1);
		
		
		tr2.commit();
		System.out.println("Successfully inserted");
		sessFact.close();

	}

}

//First level cache mostly related to session level cache it has only session level scope that means when we change session 
//it doesn't maintain cache.
//For second level cache just enable cache in hibernate-config.xml and also put jar file in class path. 
