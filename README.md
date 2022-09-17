API Guide


DB : http://localhost:8081/h2-console
	JDBC URL : jdbc:h2:file:./data/trainerDataBase
		
http://localhost:8082/h2-console/
	JDBC URL : jdbc:h2:file:./data/appointmentDataBase

Eureka Server
http://localhost:8761/ 

Appointment Service 

GET  http://localhost:8082/appointment/hello - Check service up 
GET  http://localhost:8082/appointment/trainerSlots/Christy%20Schumm  - trainer availability by trainer name 
GET  http://localhost:8082/appointment/id/8  - View  appointment by ID DELETE http://localhost:8082/appointment/cancelAppointment/5 {appointment ID}

POST http://localhost:8082/appointment/{customerName}/add
 		example : http://localhost:8082/appointment/shravani/add {
        "slotId": 1,
        "slotBegin": "09:00AM",
        "slotEnd": "09:30AM",
        "trainerName": "Christy Schumm",
        "status": "Available",
        "day": "Monday"
    }



Trainer Service
GET http://localhost:8081/trainer/hello 
GET http://localhost:8081/trainer/all - change query to select distinct
GET http://localhost:8081/trainer/slots/Natalia Stanton Jr.   POST :  http://localhost:8081/trainer/upload  PoST : http://localhost:8081/trainer/add  {
    "trainerName": “Antony”,
    "dayOfWeek": "Monday",
    "availableFrom": "9:00AM",
    "availableTo": "5.30PM"
}


Whats is DONE
- Shows only available Slots 
-  Try booking Booked Slot - Gives error message Slot already Booked
-  Test case for Generate Slots 
- -Customer name is taken via the URL only 

What is NOT DONE
** Validation for Week input is NOT DONE
** Exception Handling NOT DONE
** NO need to persist available from till in Trainer DB Table 


