package edu.cs157b.hibernate;

import javax.persistence.*;

@Entity
@Table(name="Appointments")
//@NamedQuery(name = "Appointments.findByName", query = "from Appointments where appointmentId = :appointmentId")
public class Appointments {

	private int appointmentId;
	private String date;
	private String assignedDoctor;
	
	@Id
	@GeneratedValue
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	
	@Column(name="Appointment_Date")
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getAssignedDoctor() {
		return assignedDoctor;
	}
	public void setAssignedDoctor(String assignedDoctor) {
		this.assignedDoctor = assignedDoctor;
	}
	
	
}