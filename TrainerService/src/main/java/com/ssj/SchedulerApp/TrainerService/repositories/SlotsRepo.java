package com.ssj.SchedulerApp.TrainerService.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ssj.SchedulerApp.TrainerService.Model.TrainerSlot;

public interface SlotsRepo extends JpaRepository<TrainerSlot, Integer> {

	// find By Trainer Name
	List<TrainerSlot> findByTrainerName(String name);

}
