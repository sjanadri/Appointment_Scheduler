package com.ssj.SchedulerApp.TrainerService.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssj.SchedulerApp.TrainerService.Model.Trainer;

public interface TrainerRepo extends JpaRepository<Trainer, Integer> {

	//findByDay (all trainers and slots )
	List<Trainer> findTrainerBydayOfWeek(String day);

	//findByname(all available Days and  slots)
	Trainer findTrainerByTrainerName(String name);
	
}
