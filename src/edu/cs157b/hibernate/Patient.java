package edu.cs157b.hibernate;

public class Patient extends Person {
	
	private int id;
	private String DOB; // (MM/DD/YYYY)
	
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
}
