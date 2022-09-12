package com.ssj.SchedulerApp.TrainerService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ssj.SchedulerApp.TrainerService.Model.ResponseMessage;
import com.ssj.SchedulerApp.TrainerService.Model.Trainer;
import com.ssj.SchedulerApp.TrainerService.Model.TrainerSlot;
import com.ssj.SchedulerApp.TrainerService.repositories.SlotsRepo;
import com.ssj.SchedulerApp.TrainerService.repositories.TrainerRepo;
import com.ssj.SchedulerApp.TrainerService.util.CSVUtil;
import com.ssj.SchedulerApp.TrainerService.util.GenerateSlots;

@RestController
@RequestMapping("/trainer")
public class TrainerController {

	@Autowired
	private TrainerRepo repo;
	
	@Autowired
	private SlotsRepo slotsRepo ;
	
	@Autowired
	private SlotsService service;

	// to test service reachable
	@RequestMapping(path = "/hello")
	public ResponseEntity<String> test() {
		return new ResponseEntity<>("hello", HttpStatus.OK);
	}

	@GetMapping(path = "/all")
	public ResponseEntity<java.util.List<Trainer>> getAllTrainers() {

		List<Trainer> allTrainers = repo.findAll();
		return new ResponseEntity<>(allTrainers, HttpStatus.OK);
	}

	@PostMapping(value = "/add")
	public ResponseEntity<Trainer> addTrainer(@RequestBody Trainer newTrainer) {
		System.out.println(newTrainer);

		// generate Slots for trainer Added
		List<TrainerSlot> trainerSlots = GenerateSlots.createSlotsforTrainer(newTrainer);
		newTrainer.setTrainerSlots(trainerSlots);
		Trainer trainer = repo.save(newTrainer);
		return new ResponseEntity<>(trainer, HttpStatus.OK);
	}

	@RequestMapping(path = "/slots/{name}")
	public ResponseEntity<List<TrainerSlot>> getSlotsByTrainerName(@PathVariable String name) {
		
		System.out.println("Encoded URL" + name);
		List<TrainerSlot> trainerSlots = slotsRepo.findByTrainerName(name);
		
		return new ResponseEntity<>(trainerSlots, HttpStatus.OK);
	}
	
	//CSV upload
	@PostMapping("/upload")
	  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
	    String message = "";
	    
	    if (CSVUtil.hasCSVFormat(file)) {
	      try {
	    	  service.save(file);

	        message = "Uploaded the file successfully: " + file.getOriginalFilename();
	        
	        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/api/csv/download/")
	                .path(file.getOriginalFilename())
	                .toUriString();

	        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message,fileDownloadUri));
	      } catch (Exception e) {
	        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message,""));
	      }
	    }

	    message = "Please upload a csv file!";
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message,""));
	  }

}
