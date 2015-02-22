package edu.cs157b.hibernate;

import javax.persistence.*;

@Entity
@Table(name="Patient")
@NamedQuery(name = "Patient.findByName", query = "from Patient where name = :name")
public class Patient {
	//name, DOB (MM/DD/YYYY), scheduled appointments, and prescriptions
	private int patientId;
	private String name;
	private String DOB; // (MM/DD/YYYY)
	
	private Appointments appointment;

	@Id
	@GeneratedValue
	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	@Column(name="Patient_Name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public Appointments getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointments appointment) {
		this.appointment = appointment;
	}
	
	public String toString(){
		return patientId+ " " + name;		
	}

}
