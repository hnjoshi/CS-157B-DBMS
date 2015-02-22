package edu.cs157b.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hnjoshi.cs157b.HibernateUtil;

public class HospitalTester {
	
	private static SessionFactory sessionFactory; 
    private static Transaction transaction;
    private static Session session; 

	public static void main(String[] args) {
		
		sessionFactory = HibernateUtil.getSessionFactory();
		
		Patient patient = new Patient();	// transient object
		patient.setName("Madar"); 			// only mutates the java object in Heap
		patient.setPatientId(1);
		
		try{
		       
		       session = sessionFactory.openSession();
		       transaction = session.beginTransaction();
		       
		       session.save(patient); // patient is now persistent object
		       
		       patient.setPatientId(2);   // updates on the object will be persisted
		       patient.setPatientId(3);
		       // session.update(patient); // no need
		      
		       System.out.println("1:" + patient);
		       System.out.println("2:" + session.get(Patient.class, new Integer(1)));
		       
		      
		       session.evict(patient); // detached during the transaction
		       //session.save(patient); // it will create another tuple in db
		       session.update(patient); //way to go
		       patient.setPatientId(4);;  
		       
		       
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
