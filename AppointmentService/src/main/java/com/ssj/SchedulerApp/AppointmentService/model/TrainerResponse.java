package com.ssj.SchedulerApp.AppointmentService.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value= {"handler","hibernateLazyInitializer","FieldHandler"})
public class TrainerResponse {

	// @JsonProperty("id")
	int id;
	String trainerName;
	String dayOfWeek;
	String availableFrom;
	String availableTo;
	List<AvailableSlots> trainerSlots;

	/*
	 * public TrainerResponse(int id, String trainerName, String dayOfWeek, String
	 * availableFrom, String availableTo, List<AvailableSlots> trainerSlots) {
	 * super(); this.id = id; this.trainerName = trainerName; this.dayOfWeek =
	 * dayOfWeek; this.availableFrom = availableFrom; this.availableTo =
	 * availableTo; this.trainerSlots = trainerSlots; }
	 */

	public List<AvailableSlots> getTrainerSlots() {
		return trainerSlots;
	}

	public void setTrainerSlots(List<AvailableSlots> trainerSlots) {
		this.trainerSlots = trainerSlots;
	}

}
