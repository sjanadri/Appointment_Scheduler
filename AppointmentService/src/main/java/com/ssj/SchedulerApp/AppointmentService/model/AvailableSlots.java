package com.ssj.SchedulerApp.AppointmentService.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class AvailableSlots {
	
	String trainerName;
	List<Appointment> availableSlots;
	
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public List<Appointment> getAvailableSlots() {
		return availableSlots;
	}
	public void setAvailableSlots(List<Appointment> availableSlots) {
		this.availableSlots = availableSlots;
	}

}
