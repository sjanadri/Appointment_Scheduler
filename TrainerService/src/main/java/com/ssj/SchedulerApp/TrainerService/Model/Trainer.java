package com.ssj.SchedulerApp.TrainerService.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Trainer")
public class Trainer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	//@Column(unique = true)
	String trainerName;
	String dayOfWeek;
	String availableFrom;
	String availableTo;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	public List<TrainerSlot> trainerSlots;

	public Trainer(String trainerName, String dayOfWeek, String availableFrom, String availableTo) {
		super();
		this.trainerName = trainerName;
		this.dayOfWeek = dayOfWeek;
		this.availableFrom = availableFrom;
		this.availableTo = availableTo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public String getAvailableFrom() {
		return availableFrom;
	}

	public void setAvailableFrom(String string) {
		this.availableFrom = string;
	}

	public String getAvailableTo() {
		return availableTo;
	}

	public void setAvailableTo(String availableTo) {
		this.availableTo = availableTo;
	}

	public List<TrainerSlot> getTrainerSlots() {
		return trainerSlots;
	}

	public void setTrainerSlots(List<TrainerSlot> trainerSlots) {
		this.trainerSlots = trainerSlots;
	}

}
