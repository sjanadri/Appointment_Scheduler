import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class GenerateSlots_test {
	
	public static void main(String[] args) throws ParseException {
		
		 System.out.println("*********** Inside Main*******" );
		String firstTime = "11:00 AM";
		String lastTime = "6:00 PM";
		
		
			List<String> slots = getSlots(firstTime, lastTime);
		
	}
	
	static List<String> getSlots(String firstTime, String lastTime) throws ParseException{
		String availableFrom1="9:30 AM";  
		String availableTo1="5:30 PM"; 
		 System.out.println("*********** Inside Method*******" );
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a", Locale.ENGLISH);
		
		
		Calendar calStart = Calendar.getInstance();
		calStart.setTime(sdf.parse(availableFrom1));
		 
		Calendar calEnd = Calendar.getInstance();
		calEnd.setTime(sdf.parse(availableTo1));
		
		List<String> beginSlots = new ArrayList<>();
		
		beginSlots.add(sdf.format(calStart.getTime()));
		
		while (calEnd.after(calStart) ){
			 String timeslot = sdf.format(calStart.getTime());
	         beginSlots.add(timeslot);
	         System.out.println("*************"+timeslot);
	         calStart.add(Calendar.MINUTE, 30);
        }
		return beginSlots;  
	}

	
	

}
