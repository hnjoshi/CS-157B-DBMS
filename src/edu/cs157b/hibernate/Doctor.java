package edu.cs157b.hibernate;

public class Doctor extends Person {
	
	private int doctorId;
	private String speciality;
	
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		super.name = name;
	}
	
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	

}
