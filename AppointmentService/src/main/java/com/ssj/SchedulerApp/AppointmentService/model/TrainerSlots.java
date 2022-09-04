package com.ssj.SchedulerApp.AppointmentService.model;

import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TrainerSlots {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
 	 int slotId;
	 String trainerName;
	 Time slotBegin;
	 Time slotEnd;
	 
	 @Getter
	 @Setter
	 SlotStatus status = SlotStatus.Booked;
}
