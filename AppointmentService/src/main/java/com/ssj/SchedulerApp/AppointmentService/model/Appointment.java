package com.ssj.SchedulerApp.AppointmentService.model;

import java.sql.Time;
import java.time.LocalDate;

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
		@GeneratedValue(strategy = GenerationType.AUTO)
	 	public  int id;
	    public LocalDate appointmentDate;
	    public Time appointmentStartTime;
	    public Time appointmentEndTime;
	    public String nameOfTrainer;
	    public String nameOfCustomer;
	    
	    // private Timestamp createdAt = new Timestamp(System.currentTimeMillis());
	    //private AppointmentStatus status = AppointmentStatus.Booked;
	    //private BigDecimal price;
	    
}
	