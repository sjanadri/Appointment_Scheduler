package com.ssj.SchedulerApp.AppointmentService.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value= {"handler","FieldHandler"})
public class AvailableSlots {

	// @JsonProperty("slotId")
	int slotId;

	String slotBegin;

	String slotEnd;

	String trainerName;

	SlotStatus status;

	String day;

	public AvailableSlots(int slotId, String slotBegin, String slotEnd, String trainerName, SlotStatus status,
			String day) {
		super();
		this.slotId = slotId;
		this.slotBegin = slotBegin;
		this.slotEnd = slotEnd;
		this.trainerName = trainerName;
		this.status = status;
		this.day = day;
	}

}
