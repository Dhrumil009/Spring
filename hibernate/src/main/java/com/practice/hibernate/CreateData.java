package com.practice.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practice.hibernate.model.Employee;
import com.practice.hibernate.util.HibernateUtil;

public class CreateData {
	public static void main(String[] args) throws Exception {

	SessionFactory sessFact = HibernateUtil.getSessionFactory();
	Session session = sessFact.getCurrentSession();
	Transaction tr = session.beginTransaction();
	Employee emp = new Employee();
	emp.setEmpName("Dhrumil Munshi");
	emp.setEmpMobileNos("334-268-9925");
	emp.setEmpAddress("Atlanta-USA");
	session.save(emp);
	tr.commit();
	System.out.println("Successfully inserted");
	sessFact.close();
	}

}