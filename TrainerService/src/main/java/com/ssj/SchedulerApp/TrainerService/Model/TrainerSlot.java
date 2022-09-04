package com.ssj.SchedulerApp.TrainerService.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TrainerSlot")
public class TrainerSlot {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
 	 int slotId;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="trainer_name")
	Trainer trainer;
	
	 String slotBegin;
	 String slotEnd;
	 
	 SlotStatus status;
	 String day;
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
