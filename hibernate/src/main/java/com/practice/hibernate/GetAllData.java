package com.practice.hibernate;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.practice.hibernate.model.Employee;
import com.practice.hibernate.util.HibernateUtil;

public class GetAllData {
	public static void main(String[] args) throws Exception {

	SessionFactory sessFact = HibernateUtil.getSessionFactory();
	Session session = sessFact.getCurrentSession();
	org.hibernate.Transaction tr = session.beginTransaction();

	
	CriteriaQuery cq = session.getCriteriaBuilder().createQuery(Employee.class);
	cq.from(Employee.class);
	List<Employee> employeeList = (List<Employee>)session.createQuery(cq).getResultList();

	for (Employee employee : employeeList) {
		System.out.println("ID: " + employee.getId());
		System.out.println("Name: " + employee.getEmpName());
	}  
	

	tr.commit();
	System.out.println("Data printed");
	sessFact.close();
	}
}