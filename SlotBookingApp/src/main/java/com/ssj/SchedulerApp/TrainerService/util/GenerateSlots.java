package com.ssj.SchedulerApp.TrainerService.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class GenerateSlots {

	public List<String> getSlots(String fromTime, String toTime) throws ParseException {
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
}
