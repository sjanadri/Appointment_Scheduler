package com.ssj.SchedulerApp.TrainerService.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ssj.SchedulerApp.TrainerService.Model.Trainer;
import com.ssj.SchedulerApp.TrainerService.Model.TrainerSlot;
import com.ssj.SchedulerApp.TrainerService.repositories.SlotsRepo;
import com.ssj.SchedulerApp.TrainerService.repositories.TrainerRepo;
import com.ssj.SchedulerApp.TrainerService.util.CSVUtil;

@Service
public class SlotsService {
	
	@Autowired
	private TrainerRepo repo;
	
	@Autowired
	private SlotsRepo slotRepo;
	
	 public void save(MultipartFile file) {
		    try {
		      List<Trainer> trainers = CSVUtil.csvToTrainers(file.getInputStream());
		      System.out.println("im here with ready trainer Slots");
		      
		      List<TrainerSlot> slotsAll = 
		    		  trainers.stream()
		    		        .flatMap(t-> t.getTrainerSlots().stream())
		    		        .collect(Collectors.toList());
		      
		      slotRepo.saveAll(slotsAll);
		    
		    } catch (IOException e) {
		      throw new RuntimeException("fail to store csv data: " + e.getMessage());
		    }
		  }
}
