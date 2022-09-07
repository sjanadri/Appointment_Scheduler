package com.ssj.SchedulerApp.TrainerService.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssj.SchedulerApp.TrainerService.Model.Trainer;
import com.ssj.SchedulerApp.TrainerService.Model.TrainerSlot;
import com.ssj.SchedulerApp.TrainerService.repositories.TrainerRepo;

@RestController
@RequestMapping("/trainer")
public class TrainerController {

	@Autowired
	private TrainerRepo repo;

	@Autowired
	private SlotsService service;

	// to test service reachable
	@RequestMapping(path = "/hello")
	public ResponseEntity<String> test() {
		return new ResponseEntity<>("hello", HttpStatus.OK);
	}

	@RequestMapping(path = "/name/{name}")
	public ResponseEntity<Trainer> getByName(@PathVariable String name) {

		Trainer trainer = repo.findTrainerByTrainerName(name);
		return new ResponseEntity<>(trainer, HttpStatus.OK);
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
		List<TrainerSlot> trainerSlots = service.createSlotsforTrainer(newTrainer);
		newTrainer.setTrainerSlots(trainerSlots);
		Trainer trainer = repo.save(newTrainer);
		return new ResponseEntity<>(trainer, HttpStatus.OK);
	}

	@RequestMapping(path = "/slots/{name}")
	public ResponseEntity<List<TrainerSlot>> getSlotsByTrainerName(@PathVariable String name) {

		Trainer trainer = repo.findTrainerByTrainerName(name);
		
		List<TrainerSlot> mySlots = new ArrayList<>();
		mySlots = trainer.getTrainerSlots();
		return new ResponseEntity<>(mySlots, HttpStatus.OK);
	}

}
