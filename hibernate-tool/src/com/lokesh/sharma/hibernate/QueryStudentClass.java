/**
 * 
 */
package com.lokesh.sharma.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Lokesh
 *
 */
public class QueryStudentClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
 
		
		//Create Session Factory
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//Create Session
		Session session = sf.getCurrentSession();
		
		try {
			session.beginTransaction();
			List<Student> listOfStd = session.createQuery("from Student where first_name like '%am%'").getResultList();
			for(Student st : listOfStd) {
				System.out.println(st);	
			}
			session.getTransaction().commit();
			
		}finally {
			sf.close();
		}
	
	}

}
