package com.ssj.SchedulerApp.TrainerService.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ssj.SchedulerApp.TrainerService.Model.Trainer;
import com.ssj.SchedulerApp.TrainerService.repositories.TrainerRepo;
import com.ssj.SchedulerApp.TrainerService.util.CSVUtil;

@Service
public class SlotsService {
	
	@Autowired
	private TrainerRepo repo;
	
	 public void save(MultipartFile file) {
		    try {
		      List<Trainer> trainers = CSVUtil.csvToTrainers(file.getInputStream());
		      System.out.println("im here with ready trainer Slots");
		      
		      //if trainer already present add only Slots
		      
		      
		      repo.saveAll(trainers);
		    } catch (IOException e) {
		      throw new RuntimeException("fail to store csv data: " + e.getMessage());
		    }
		  }
}
