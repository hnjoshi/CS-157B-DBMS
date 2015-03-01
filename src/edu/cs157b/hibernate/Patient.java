package edu.cs157b.hibernate;

public class Patient extends Person {
	
	private int patientId;
	private String DOB; // (MM/DD/YYYY)
	
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	
	public String getName() {
		return name;
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
