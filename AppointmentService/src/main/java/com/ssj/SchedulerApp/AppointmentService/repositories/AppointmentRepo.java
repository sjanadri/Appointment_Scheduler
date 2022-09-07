package com.ssj.SchedulerApp.AppointmentService.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ssj.SchedulerApp.AppointmentService.model.Appointment;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Integer>{
	
	List<Appointment>  findAppointMentBynameOfTrainer(String trainerName);
	List<Appointment>  findAppointMentBynameOfCustomer(String trainerName);
	
	@Query("select a.slotId from Appointment a where a.nameOfTrainer = ?1 ")
	Set<Integer> findSlotIDbyTrainer(String name);
}

