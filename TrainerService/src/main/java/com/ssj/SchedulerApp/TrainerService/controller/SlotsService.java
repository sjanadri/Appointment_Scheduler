package com.ssj.SchedulerApp.TrainerService.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssj.SchedulerApp.TrainerService.Model.SlotStatus;
import com.ssj.SchedulerApp.TrainerService.Model.Trainer;
import com.ssj.SchedulerApp.TrainerService.Model.TrainerSlot;
import com.ssj.SchedulerApp.TrainerService.util.GenerateSlots;

@Service
public class SlotsService {
	public List<TrainerSlot> createSlotsforTrainer(Trainer trainer){
		List<TrainerSlot> trainerSlots = new ArrayList<TrainerSlot>();
		TrainerSlot slot = new TrainerSlot();
		
		//slot.setTrainerName(trainer.getTrainerName());
		slot.setDay(trainer.getDayOfWeek());
		slot.setStatus(SlotStatus.Available);
		
		GenerateSlots generateSlots = new GenerateSlots();
		try {
			List<String> slotStamps = generateSlots.getSlots(trainer.getAvailableFrom(), trainer.getAvailableTo());
			  for (int i = 0; i < slotStamps.size() - 1 ; i++) {
				  slot.setSlotBegin(slotStamps.get(i));
				  slot.setSlotEnd(slotStamps.get(i+1));
			  }
			
		} catch (ParseException e) {
			generateSlots = null;
			//e.getMessage();
		}
		
		return trainerSlots;
	}
}
