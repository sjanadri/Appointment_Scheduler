package com.ssj.SchedulerApp.AppointmentService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	int slotId;
	String appointmentStartTime;
	String appointmentEndTime;
	String nameOfTrainer;
	String nameOfCustomer;
	String status;
	
	public Appointment(int id, int slotId, String appointmentStartTime, String appointmentEndTime, String nameOfTrainer,
			String nameOfCustomer, String status) {
		super();
		this.id = id;
		this.slotId = slotId;
		this.appointmentStartTime = appointmentStartTime;
		this.appointmentEndTime = appointmentEndTime;
		this.nameOfTrainer = nameOfTrainer;
		this.nameOfCustomer = nameOfCustomer;
		this.status = status;
	}
	public Appointment() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSlotId() {
		return slotId;
	}
	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}
	public String getAppointmentStartTime() {
		return appointmentStartTime;
	}
	public void setAppointmentStartTime(String appointmentStartTime) {
		this.appointmentStartTime = appointmentStartTime;
	}
	public String getAppointmentEndTime() {
		return appointmentEndTime;
	}
	public void setAppointmentEndTime(String appointmentEndTime) {
		this.appointmentEndTime = appointmentEndTime;
	}
	public String getNameOfTrainer() {
		return nameOfTrainer;
	}
	public void setNameOfTrainer(String nameOfTrainer) {
		this.nameOfTrainer = nameOfTrainer;
	}
	public String getNameOfCustomer() {
		return nameOfCustomer;
	}
	public void setNameOfCustomer(String nameOfCustomer) {
		this.nameOfCustomer = nameOfCustomer;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
