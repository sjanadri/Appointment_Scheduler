package com.ssj.SchedulerApp.AppointmentService.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ssj.SchedulerApp.AppointmentService.model.Appointment;
import com.ssj.SchedulerApp.AppointmentService.model.AvailableSlots;
import com.ssj.SchedulerApp.AppointmentService.model.SlotStatus;
import com.ssj.SchedulerApp.AppointmentService.repositories.AppointmentRepo;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentRepo repo;

	@Autowired
	private RestTemplate restTemplate;

	// to test service reachable
	@RequestMapping(path = "/hello")
	public ResponseEntity<String> test() {
		return new ResponseEntity<>("hello", HttpStatus.OK);
	}

	// view all Appointment
	@RequestMapping(path = "/all")
	public ResponseEntity<java.util.List<Appointment>> getAllAppointments() {

		List<Appointment> allAppointments = repo.findAll();
		return new ResponseEntity<>(allAppointments, HttpStatus.OK);
	}

	// view appointment by ID
	@RequestMapping(path = "/id/{id}")
	public ResponseEntity<Appointment> getById(@PathVariable Integer id) {

		Optional<Appointment> optionalAppointment = repo.findById(id);
		Appointment appointment = optionalAppointment.get();
		return new ResponseEntity<>(appointment, HttpStatus.OK);
	}

	// add schedule appointment
	@PostMapping(path = "/{myName}/add")
	public ResponseEntity<Appointment> addAppointment(@RequestBody AvailableSlots bookSlot,
			@PathVariable("myName") String myName) {

		Appointment bookAppointment = new Appointment();

		bookAppointment.setSlotId(bookSlot.getSlotId());
		bookAppointment.setNameOfTrainer(bookSlot.getTrainerName());
		bookAppointment.setNameOfCustomer(myName);
		bookAppointment.setAppointmentStartTime(bookSlot.getSlotBegin());
		bookAppointment.setAppointmentEndTime(bookSlot.getSlotEnd());
		bookAppointment.setStatus(SlotStatus.Booked.toString());

		System.out.println(bookAppointment);
		Appointment appointment = repo.save(bookAppointment);

		return new ResponseEntity<>(appointment, HttpStatus.OK);
	}

	// view trainer available slots
	@RequestMapping(path = "/trainerSlots/{name}")
	public ResponseEntity<List<AvailableSlots>> getAvailableSlots(@PathVariable String name) {

		ResponseEntity<List<AvailableSlots>> trainerSlotsResponse = restTemplate
					.exchange("http://localhost:8081/trainer/slots/" + name,  HttpMethod.GET, null,new  ParameterizedTypeReference<List<AvailableSlots>>(){
		            });
		 
		List<AvailableSlots> trainerSlots = trainerSlotsResponse.getBody();

		Set<Integer> bookedSlots = repo.findSlotIDbyTrainer(name);
		for (Integer integer : bookedSlots) {
			System.out.println("********Im booked slot " + integer);
		}

		List<AvailableSlots> trainerSlotsAvailable = new ArrayList<>();

		for (AvailableSlots a : trainerSlots) {
			System.out.println("*****SLOT ID****** " + a.getSlotId());
			if (bookedSlots.contains(a.getSlotId())) {
				System.out.println("*****SLOT ID Skipped *** " + a.getSlotId());
				continue;
			}
			trainerSlotsAvailable.add(a);
		}

		return new ResponseEntity<List<AvailableSlots>>(trainerSlotsAvailable, HttpStatus.OK);
	}

	// cancel appointment
	@DeleteMapping(path = "/cancelAppointment/{appointmentId}")
	public ResponseEntity<Integer> deleteAppointment(@PathVariable Integer appointmentId) {
		repo.deleteById(appointmentId);
		// write logic to free the slot
		return ResponseEntity.ok(appointmentId);
	}

}
