package com.ssj.SchedulerApp.AppointmentService.model;

import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
	
		@Id 
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	 	public  int id;
	    public Time appointmentStartTime;
	    public Time appointmentEndTime;
	    public String nameOfTrainer;
	    public String nameOfCustomer;
	    public SlotStatus status;
	    
}
	