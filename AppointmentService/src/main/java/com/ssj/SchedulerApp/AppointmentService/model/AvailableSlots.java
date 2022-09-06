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

	public int getSlotId() {
		return slotId;
	}

	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}

	public String getSlotBegin() {
		return slotBegin;
	}

	public void setSlotBegin(String slotBegin) {
		this.slotBegin = slotBegin;
	}

	public String getSlotEnd() {
		return slotEnd;
	}

	public void setSlotEnd(String slotEnd) {
		this.slotEnd = slotEnd;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public SlotStatus getStatus() {
		return status;
	}

	public void setStatus(SlotStatus status) {
		this.status = status;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	
}
