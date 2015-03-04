package edu.cs157b.hibernate;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HospitalTester {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		@SuppressWarnings("deprecation")
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		Patient p = new Patient();
		Doctor d = new Doctor();
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
		Date date = new Date();
		
		p.setName("Pat1");
		p.setDOB(sdf.format(date));
		d.setName("Doc1");
		d.setSpeciality("Medical");
		
		s.save(p);
		s.save(d);
		s.flush();  //forces Hibernate to sync with database
		t.commit();
		
		// get inserted record
		// Note: use 'load' if we know for sure data exists, if not sure then use 'get'
		p = (Patient)s.load(Patient.class, new Integer(1));
		System.out.println(p.getPatientId());
		System.out.println(p.getName());
		System.out.println(p.getDOB());
		
		// get the row and update it
		t = s.beginTransaction();
		p.setName("newPat1");
		s.update(p);
		s.flush();
		t.commit();
		
		// delete the record
		p = (Patient)s.get(Patient.class, new Integer(1));
		t = s.beginTransaction();
		s.delete(p);
		s.flush();
		t.commit();
		
		s.close();	
	}
}