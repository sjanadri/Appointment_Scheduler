package com.ssj.SchedulerApp.AppointmentService.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TrainerResponse {

	int id;
	String trainerName;
	String dayOfWeek;
	String availableFrom;
	String availableTo;
	List<AvailableSlots> trainerSlots;


	public List<AvailableSlots> getTrainerSlots() {
		return trainerSlots;
	}

	public void setTrainerSlots(List<AvailableSlots> trainerSlots) {
		this.trainerSlots = trainerSlots;
	}

}
