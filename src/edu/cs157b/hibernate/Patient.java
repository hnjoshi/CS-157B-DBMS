package edu.cs157b.hibernate;

import java.util.List;

public class Patient extends Person {
	
	private int id;
	private String DOB; // (MM/DD/YYYY)
	private List appt;
	
	public int getPatientId() {
		return id;
	}
	public void setPatientId(int patientId) {
		id = patientId;
	}
	
	public String getName() {
		return super.name;
	}
	public void setName(String name) {
		super.name = name;
	}
	
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String string) {
		DOB = string;
	}
	public List getAppt() {
		return appt;
	}
	public void setAppt(List appt) {
		this.appt = appt;
	}
	
	
}
