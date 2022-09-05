package com.ssj.SchedulerApp.TrainerService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssj.SchedulerApp.TrainerService.Model.TrainerSlot;

@Repository
public interface SlotsRepository extends JpaRepository<TrainerSlot, Integer> {

}
