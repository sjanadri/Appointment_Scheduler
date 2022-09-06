package com.ssj.SchedulerApp.AppointmentService.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.ssj.SchedulerApp.AppointmentService.model.TrainerResponse;
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
	// update trainer Availability(same service or trainer service)
	@PostMapping(path = "/add")
	public ResponseEntity<Appointment> addAppointment(@RequestBody Appointment newAppointment) {
		System.out.println(newAppointment);
		Appointment appointment = repo.save(newAppointment);
		return new ResponseEntity<>(appointment, HttpStatus.OK);
	}

	// view trainer availability
	@SuppressWarnings("unchecked")
	@RequestMapping(path = "/trainerSlots/{name}")
	public ResponseEntity<List<AvailableSlots>> getAvailableSlots(@PathVariable String name) {

		List<AvailableSlots> trainerSlots = new ArrayList<>();
		trainerSlots = restTemplate.getForObject("http://localhost:8081/trainer/slots/" + name, List.class);
		
		return new ResponseEntity<List<AvailableSlots>>(trainerSlots, HttpStatus.OK);
	}

	// cancel appointment
	@DeleteMapping(path = "/cancelAppointment/{appointmentId}")
	public ResponseEntity<Integer> deleteAppointment(@PathVariable Integer appointmentId) {
		repo.deleteById(appointmentId);
		// write logic to free the slot
		return ResponseEntity.ok(appointmentId);
	}

	/*
	 * //view appointment by trainer Name
	 * 
	 * @RequestMapping(path ="/trainername/{name}") public
	 * ResponseEntity<List<Appointment>> getByTrainerName(@PathVariable String name)
	 * { List<Appointment> trainerAppointments =
	 * repo.findAppointMentBynameOfTrainer(name); return new
	 * ResponseEntity<>(trainerAppointments, HttpStatus.OK); }
	 */
	/*
	 * //view appointment by customer Name
	 * 
	 * @RequestMapping(path ="/customername/{name}") public
	 * ResponseEntity<List<Appointment>> getByCustName(@PathVariable String name) {
	 * List<Appointment> customerAppointments =
	 * repo.findAppointMentBynameOfCustomer(name); return new
	 * ResponseEntity<>(customerAppointments, HttpStatus.OK); }
	 */

}
