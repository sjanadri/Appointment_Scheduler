package com.ssj.SchedulerApp.TrainerService.util;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.ssj.SchedulerApp.TrainerService.Model.SlotStatus;
import com.ssj.SchedulerApp.TrainerService.Model.Trainer;
import com.ssj.SchedulerApp.TrainerService.Model.TrainerSlot;

@RunWith(MockitoJUnitRunner.class)
public class GenerateSlotsTest {
	
	private Trainer mockTrainer;
	private TrainerSlot mockTrainerSlot;
	
	private GenerateSlots testGenerateSlots;
	private GenerateSlots spyGenerateSlots;
	
	@Before
	public void setup() throws Exception {
		mockTrainer = mock(Trainer.class);
		mockTrainerSlot = mock(TrainerSlot.class);
		
		testGenerateSlots = new GenerateSlots();
		spyGenerateSlots = spy(testGenerateSlots);
	}

	@SuppressWarnings("static-access")
	@Test
	public void createSlotsforTrainer_success() {
		Trainer trainer = new Trainer("Christy Schumm", "Monday", "9:00AM", "11:00AM");
		
		List<TrainerSlot> mockSlotList = new ArrayList<TrainerSlot>();
		TrainerSlot slot = new TrainerSlot();
		slot.setDay("Monday");
		slot.setTrainerName("Christy Schumm");
		slot.setStatus(SlotStatus.Available);
		slot.setSlotBegin("09:00AM");
		slot.setSlotEnd("09:30AM");
		
		mockSlotList.add(slot);
		
		TrainerSlot slot1 = new TrainerSlot();
		slot1.setDay("Monday");
		slot1.setTrainerName("Christy Schumm");
		slot1.setStatus(SlotStatus.Available);
		slot1.setSlotBegin("09:30AM");
		slot1.setSlotEnd("10:00AM");
		mockSlotList.add(slot1);
		
		TrainerSlot slot2 = new TrainerSlot();
		slot2.setDay("Monday");
		slot2.setTrainerName("Christy Schumm");
		slot2.setStatus(SlotStatus.Available);
		slot2.setSlotBegin("10:00AM");
		slot2.setSlotEnd("10:30AM");
		mockSlotList.add(slot2);
		
		TrainerSlot slot3 = new TrainerSlot();
		slot3.setDay("Monday");
		slot3.setTrainerName("Christy Schumm");
		slot3.setStatus(SlotStatus.Available);
		slot3.setSlotBegin("10:30AM");
		slot3.setSlotEnd("11:00AM");
		mockSlotList.add(slot3);
		
	   assertEquals(mockSlotList, spyGenerateSlots.createSlotsforTrainer(trainer));
		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void createSlotsforTrainer_success_NOTaRoundOffValue() {
		Trainer trainer = new Trainer("Christy Schumm", "Monday", "9:00AM", "10:40AM");
		
		List<TrainerSlot> mockSlotList = new ArrayList<TrainerSlot>();
		TrainerSlot slot = new TrainerSlot();
		slot.setDay("Monday");
		slot.setTrainerName("Christy Schumm");
		slot.setStatus(SlotStatus.Available);
		slot.setSlotBegin("09:00AM");
		slot.setSlotEnd("09:30AM");
		
		mockSlotList.add(slot);
		
		TrainerSlot slot1 = new TrainerSlot();
		slot1.setDay("Monday");
		slot1.setTrainerName("Christy Schumm");
		slot1.setStatus(SlotStatus.Available);
		slot1.setSlotBegin("09:30AM");
		slot1.setSlotEnd("10:00AM");
		mockSlotList.add(slot1);
		
		TrainerSlot slot2 = new TrainerSlot();
		slot2.setDay("Monday");
		slot2.setTrainerName("Christy Schumm");
		slot2.setStatus(SlotStatus.Available);
		slot2.setSlotBegin("10:00AM");
		slot2.setSlotEnd("10:30AM");
		mockSlotList.add(slot2);
		
	   assertEquals(mockSlotList, spyGenerateSlots.createSlotsforTrainer(trainer));
		
	}
	
	
	@SuppressWarnings("static-access")
	@Test
	public void createSlotsforTrainer_success_TOlesserThanFROM() {
		Trainer trainer = new Trainer("Christy Schumm", "Monday", "9:00AM", "8:40AM");
		
		List<TrainerSlot> mockSlotList = new ArrayList<TrainerSlot>();
	   assertEquals(mockSlotList, spyGenerateSlots.createSlotsforTrainer(trainer));
		
	}
}
