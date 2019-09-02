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
public class DriverClass {

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
			//use session to save the java object
			
			//Create a student object
			System.out.println("Create a new Object");
			//Student std = new Student("Lokesh", "Sharma", "lokesh.sharma@abcd.com");
			Student std2 = new Student("Rma", "Sharma", "ram@abcd.com");
			Student std3 = new Student("Shyam", "Sharma", "shyam@abcd.com");
			Student std4 = new Student("Ghanshyam", "Sharma", "ghanshyam@abcd.com");
			
			//begin transaction
			System.out.println("Begin Transaction");
			session.beginTransaction();
			
			//save object
			System.out.println("Save the Onject in DB");
			//session.save(std);
			session.save(std2);
			session.save(std3);
			session.save(std4);
			
			//end transaction
			System.out.println("end Transaction");
			session.getTransaction().commit();
			
		}finally {
			sf.close();
		}
	}

}
