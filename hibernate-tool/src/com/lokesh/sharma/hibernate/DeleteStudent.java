/**
 * 
 */
package com.lokesh.sharma.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Lokesh
 *
 */
public class DeleteStudent {

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
			Student st = session.get(Student.class, 6);
			session.delete(st);
			
			//Another way
			session.createQuery("delete from Student where id = 9").executeUpdate();
			session.getTransaction().commit();
			
		}finally {
			sf.close();
		}
	
	}

}
