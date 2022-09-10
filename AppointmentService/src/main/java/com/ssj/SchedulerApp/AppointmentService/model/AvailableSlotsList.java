package com.ssj.SchedulerApp.AppointmentService.model;

import java.util.ArrayList;
import java.util.List;

public class AvailableSlotsList {

	
	private List<AvailableSlots> availableSlotsList;

    public AvailableSlotsList() {
    	availableSlotsList = new ArrayList<>();
    }

	public List<AvailableSlots> getAvailableSlotsList() {
		return availableSlotsList;
	}

	public void setAvailableSlotsList(List<AvailableSlots> availableSlotsList) {
		this.availableSlotsList = availableSlotsList;
	}
    
    
    
}
