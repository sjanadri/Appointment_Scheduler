import java.sql.Time;

public class TrainerSlot {
	
	
 	 int slotId;
	 String trainerName;
	 Time slotBegin;
	 Time slotEnd;
	 
	 SlotStatus status = SlotStatus.Booked;
	 
	 public int getSlotId() {
		return slotId;
	}

	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public Time getSlotBegin() {
		return slotBegin;
	}

	public void setSlotBegin(Time slotBegin) {
		this.slotBegin = slotBegin;
	}

	public Time getSlotEnd() {
		return slotEnd;
	}

	public void setSlotEnd(Time slotEnd) {
		this.slotEnd = slotEnd;
	}

	public SlotStatus getStatus() {
		return status;
	}

	public void setStatus(SlotStatus status) {
		this.status = status;
	}
	
}
