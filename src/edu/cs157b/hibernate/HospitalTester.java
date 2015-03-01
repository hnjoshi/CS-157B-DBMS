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
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
		Date date = new Date();
		System.out.println(sdf.format(date));
		
		p.setName("First");
		p.setDOB(sdf.format(date));
		
		s.save(p);
		s.flush();  //Generating SQL queries
		t.commit();
		s.close();
		
	}

}
