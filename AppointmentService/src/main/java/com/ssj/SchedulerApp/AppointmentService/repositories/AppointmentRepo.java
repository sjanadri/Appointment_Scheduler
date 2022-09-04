package com.ssj.SchedulerApp.AppointmentService.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssj.SchedulerApp.AppointmentService.model.Appointment;

public interface AppointmentRepo extends JpaRepository<Appointment, Integer>{
	
	List<Appointment>  findAppointMentBynameOfTrainer(String trainerName);
	List<Appointment>  findAppointMentBynameOfCustomer(String trainerName);
}
