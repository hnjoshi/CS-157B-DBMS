package edu.cs157b.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HospitalTester {
	
	private static SessionFactory sessionFactory; 
    private static Transaction transaction;
    private static Session session; 

	public static void main(String[] args) {
				
		// issue with sessionFactory
		sessionFactory = HibernateUtil.getSessionFactory();
		
		Patient patient = new Patient();	// transient object
		patient.setName("Hello"); 			// only mutates the java object in Heap
		patient.setPatientId(1);
		
		try{
		       
		       session = sessionFactory.openSession();
		       transaction = session.beginTransaction();
		       
		       session.save(patient); // patient is now persistent object
		       System.out.println("1:" + patient);
		       System.out.println("2:" + session.get(Patient.class, new Integer(1)));		       
		       
		       transaction.commit(); // if you comment this out, no tuple is created in db. 
		      }
		       catch (HibernateException he)
		       {
		           transaction.rollback();
		           System.out.println("Transaction is rolled back.");
		       }
		      finally
		      { session.close(); }

	}

}
