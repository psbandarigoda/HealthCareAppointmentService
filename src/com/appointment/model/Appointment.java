package com.appointment.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Appointment {


	private Integer id;
	private String patientId;
	private String hospital;
	private String doctor;
	private String date;

	
	public Appointment() {
		super();
	}

	
	public Appointment(Integer id, String patientId, String hospital, String doctor, String date) {
		super();
		this.id = id;
		this.patientId = patientId;
		this.hospital = hospital;
		this.doctor = doctor;
		this.date = date;
	}



	public Integer getID() {
		return id;
	}


	public void setID(Integer iD) {
		id = iD;
	}


	public String getPatientId() {
		return patientId;
	}


	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}


	public String getHospital() {
		return hospital;
	}


	public void setHospital(String hospital) {
		this.hospital = hospital;
	}


	public String getDoctor() {
		return doctor;
	}


	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", patientId=" + patientId + ", hospital=" + hospital + ", doctor=" + doctor + ", date="
				+ date + "]";
	}
	
	
}
