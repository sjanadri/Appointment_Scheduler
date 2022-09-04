package com.ssj.SchedulerApp.TrainerService.Model;

import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Trainer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	public String trainerName;
	public String dayOfWeek;
	public Time availableFrom;
	public Time availableTo;
	
}
