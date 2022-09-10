package com.ssj.SchedulerApp.TrainerService.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import com.ssj.SchedulerApp.TrainerService.Model.SlotStatus;
import com.ssj.SchedulerApp.TrainerService.Model.Trainer;
import com.ssj.SchedulerApp.TrainerService.Model.TrainerSlot;

public class GenerateSlots {

	public static List<String> getSlots(String fromTime, String toTime) throws ParseException {
		// String availableFrom1="9:30 AM";
		// String availableTo1="5:30 PM";
		System.out.println("*********** Inside Method*******");
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a", Locale.ENGLISH);

		Calendar calStart = Calendar.getInstance();
		calStart.setTime(sdf.parse(fromTime));

		Calendar calEnd = Calendar.getInstance();
		calEnd.setTime(sdf.parse(toTime));

		List<String> beginSlots = new ArrayList<>();

		beginSlots.add(sdf.format(calStart.getTime()));
		System.out.println("*************" + beginSlots.get(0));

		while (calEnd.after(calStart)) {

			calStart.add(Calendar.MINUTE, 30);

			if (calStart.after(calEnd)) {
				break;
			}

			String timeslot = sdf.format(calStart.getTime());
			beginSlots.add(timeslot);
			System.out.println("*************" + timeslot);
		}
		return beginSlots;
	}
	
	public static List<TrainerSlot> createSlotsforTrainer(Trainer trainer) {
		List<TrainerSlot> trainerSlots = new ArrayList<TrainerSlot>();

		try {
			List<String> slotStamps = getSlots(trainer.getAvailableFrom(), trainer.getAvailableTo());

			for (int i = 0; i < slotStamps.size() - 1; i++) {
				TrainerSlot slot = new TrainerSlot();

				slot.setTrainerName(trainer.getTrainerName());
				slot.setDay(trainer.getDayOfWeek());
				slot.setStatus(SlotStatus.Available);
				slot.setSlotBegin(slotStamps.get(i));
				slot.setSlotEnd(slotStamps.get(i + 1));

				trainerSlots.add(slot);
			}

		} catch (ParseException e) {
			trainerSlots = null;
			// e.getMessage();
		}

		return trainerSlots;
	}
}
