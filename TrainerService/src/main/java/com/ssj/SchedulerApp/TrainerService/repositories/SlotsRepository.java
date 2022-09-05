package com.ssj.SchedulerApp.TrainerService.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import com.ssj.SchedulerApp.TrainerService.Model.TrainerSlot;

@Repository
public interface SlotsRepository extends CrudRepository<TrainerSlot, Integer> {
	/*
	 * @Override
	 * 
	 * @Query("select slot from TrainerSlot slot left join fetch slot.Trainer")
	 * List<TrainerSlot> findAll();
	 */
	//List<TrainerSlot> findAllByTrainerName(String name);
}
